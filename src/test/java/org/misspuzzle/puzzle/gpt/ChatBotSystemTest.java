package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class ChatBotSystemTest {

    private ChatBotSystem.EventBus eventBus;

    @BeforeEach
    public void setUp() {
        eventBus = new ChatBotSystem.EventBus();
    }

    // ------------------------------------------------------------------
    // TacoBot
    // ------------------------------------------------------------------
    @Test
    public void testTacoBotShouldActivate() {
        ChatBotSystem.TacoBot bot = new ChatBotSystem.TacoBot(eventBus);

        assertTrue(bot.shouldActivate("Alice", "/givetaco 🌮🌮 @bob"));
        assertFalse(bot.shouldActivate("Alice", "Hello"));
        assertFalse(bot.shouldActivate("Alice", "/meet Bob"));
    }

    @Test
    public void testTacoBotGivesTacos() {
        ChatBotSystem.TacoBot bot = new ChatBotSystem.TacoBot(eventBus);

        List<String> responses = bot.execute("Cindy", "/givetaco 🌮🌮 @justin");

        assertEquals(1, responses.size());
        assertTrue(responses.get(0).contains("2 🌮's"));
        assertTrue(responses.get(0).contains("now have 2 🌮s"));
    }

    @Test
    public void testTacoBotAccumulates() {
        ChatBotSystem.TacoBot bot = new ChatBotSystem.TacoBot(eventBus);

        bot.execute("Alice", "/givetaco 🌮🌮 @bob");
        List<String> responses = bot.execute("Charlie", "/givetaco 🌮 @bob");

        assertTrue(responses.get(0).contains("now have 3 🌮s"));
    }

    // ------------------------------------------------------------------
    // MeetBot
    // ------------------------------------------------------------------
    @Test
    public void testMeetBotShouldActivate() {
        ChatBotSystem.MeetBot bot = new ChatBotSystem.MeetBot(eventBus);

        assertTrue(bot.shouldActivate("Bob", "/meet Alice"));
        assertFalse(bot.shouldActivate("Bob", "Hello"));
    }

    @Test
    public void testMeetBotCreatesLink() {
        ChatBotSystem.MeetBot bot = new ChatBotSystem.MeetBot(eventBus);

        List<String> responses = bot.execute("Bob", "/meet Alice");

        assertEquals(1, responses.size());
        assertTrue(responses.get(0).contains("Google Meet with @Bob, and Alice"));
        assertTrue(responses.get(0).contains("https://meet.google.com"));
    }

    @Test
    public void testMeetBotPublishesEvents() {
        List<ChatBotSystem.Event> received = new ArrayList<>();

        eventBus.subscribe("user_meeting_started", event -> received.add(event));

        ChatBotSystem.MeetBot bot = new ChatBotSystem.MeetBot(eventBus);
        bot.execute("Frank", "/meet David");

        assertEquals(2, received.size());
        assertEquals("Frank", received.get(0).data.get("username"));
        assertEquals("David", received.get(1).data.get("username"));
    }

    // ------------------------------------------------------------------
    // AwayBot
    // ------------------------------------------------------------------
    @Test
    public void testAwayBotSetStatus() {
        ChatBotSystem.AwayBot bot = new ChatBotSystem.AwayBot(eventBus);

        List<String> responses = bot.execute("David", "/away out for lunch");

        assertTrue(responses.isEmpty()); // /away produces no message
    }

    @Test
    public void testAwayBotNotifiesOnMention() {
        ChatBotSystem.AwayBot bot = new ChatBotSystem.AwayBot(eventBus);

        bot.execute("David", "/away out for lunch");
        List<String> responses = bot.execute("Emily", "Anyone around? David?");

        assertEquals(1, responses.size());
        assertTrue(responses.get(0).contains("David is away: out for lunch"));
    }

    @Test
    public void testAwayBotHandlesMeetingEvent() {
        ChatBotSystem.AwayBot bot = new ChatBotSystem.AwayBot(eventBus);

        // Simulate MeetBot publishing an event
        eventBus.publish(new ChatBotSystem.Event(
                "user_meeting_started",
                Map.of("username", "Alice")
        ));

        List<String> responses = bot.execute("Bob", "Hey Alice, free?");

        assertEquals(1, responses.size());
        assertTrue(responses.get(0).contains("Alice is away"));
        assertTrue(responses.get(0).contains("may be in a meeting"));
    }

    // ------------------------------------------------------------------
    // Integration – full conversation
    // ------------------------------------------------------------------
    @Test
    public void testFullConversation() {
        ChatBotSystem.ChatRoom room = new ChatBotSystem.ChatRoom();

        room.register(new ChatBotSystem.AwayBot(room.eventBus));
        room.register(new ChatBotSystem.MeetBot(room.eventBus));
        room.register(new ChatBotSystem.TacoBot(room.eventBus));

        room.sendMessage("Alice", "Hello");
        room.sendMessage("Bob", "Hi");
        room.sendMessage("Alice", "Nice job on your presentations");
        room.sendMessage("Cindy", "/givetaco 🌮🌮 @justin");
        room.sendMessage("Alice", "Bob let's meet");
        room.sendMessage("Bob", "/meet Alice");
        room.sendMessage("David", "/away out for lunch");
        room.sendMessage("Emily", "Anyone around?");
        room.sendMessage("Frank", "/meet David");

        List<String> messages = room.getMessages();

        // Basic checks
        assertTrue(messages.contains("Alice: Hello"));
        assertTrue(messages.contains("Cindy: /givetaco 🌮🌮 @justin"));
        assertTrue(messages.stream().anyMatch(m -> m.contains("TacoBot") && m.contains("2 🌮's")));
        assertTrue(messages.stream().anyMatch(m -> m.contains("MeetBot") && m.contains("Google Meet with @Bob")));
        assertTrue(messages.stream().anyMatch(m -> m.contains("AwayBot") && m.contains("David is away")));
        assertTrue(messages.stream().anyMatch(m -> m.contains("MeetBot") && m.contains("@Frank")));
    }
}