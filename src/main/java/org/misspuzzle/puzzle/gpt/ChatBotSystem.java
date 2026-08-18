package org.misspuzzle.puzzle.gpt;

import java.util.*;

public class ChatBotSystem {

    // ------------------------------------------------------------------
    // Event
    // ------------------------------------------------------------------
    public static class Event {
        public final String type;
        public final Map<String, Object> data;

        public Event(String type, Map<String, Object> data) {
            this.type = type;
            this.data = data;
        }
    }

    // ------------------------------------------------------------------
    // Simple listener interface (no java.util.function)
    // ------------------------------------------------------------------
    public interface EventListener {
        void onEvent(Event event);
    }

    // ------------------------------------------------------------------
    // EventBus
    // ------------------------------------------------------------------
    public static class EventBus {
        private final Map<String, List<EventListener>> subscribers = new HashMap<>();

        public void subscribe(String eventType, EventListener listener) {
            subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
        }

        public void publish(Event event) {
            List<EventListener> list = subscribers.get(event.type);
            if (list != null) {
                for (EventListener listener : list) {
                    listener.onEvent(event);
                }
            }
        }
    }

    // ------------------------------------------------------------------
    // Bot interface
    // ------------------------------------------------------------------
    public interface Bot {
        boolean shouldActivate(String name, String msg);
        List<String> execute(String name, String msg);
    }

    // ------------------------------------------------------------------
    // AwayBot
    // ------------------------------------------------------------------
    public static class AwayBot implements Bot, EventListener {
        private final Map<String, String> awayStatuses = new HashMap<>();

        public AwayBot(EventBus eventBus) {
            eventBus.subscribe("user_meeting_started", this);
        }

        @Override
        public void onEvent(Event event) {
            if ("user_meeting_started".equals(event.type)) {
                String username = (String) event.data.get("username");
                awayStatuses.put(username, "@" + username + " may be in a meeting right now");
            }
        }

        @Override
        public boolean shouldActivate(String name, String msg) {
            if (msg.startsWith("/away ")) return true;
            for (String user : awayStatuses.keySet()) {
                if (msg.contains(user)) return true;
            }
            return false;
        }

        @Override
        public List<String> execute(String name, String msg) {
            List<String> responses = new ArrayList<>();

            if (msg.startsWith("/away ")) {
                String reason = msg.substring(6);
                awayStatuses.put(name, reason);
                return responses; // no output
            }

            for (Map.Entry<String, String> e : awayStatuses.entrySet()) {
                if (msg.contains(e.getKey())) {
                    responses.add("AwayBot: " + e.getKey() + " is away: " + e.getValue());
                }
            }
            return responses;
        }
    }

    // ------------------------------------------------------------------
    // MeetBot
    // ------------------------------------------------------------------
    public static class MeetBot implements Bot {
        private final EventBus eventBus;

        public MeetBot(EventBus eventBus) {
            this.eventBus = eventBus;
        }

        @Override
        public boolean shouldActivate(String name, String msg) {
            return msg.startsWith("/meet ");
        }

        @Override
        public List<String> execute(String name, String msg) {
            String[] parts = msg.split(" ", 2);
            if (parts.length < 2) return List.of();

            String other = parts[1].trim();

            // Publish events – AwayBot will react
            eventBus.publish(new Event("user_meeting_started", Map.of("username", name)));
            eventBus.publish(new Event("user_meeting_started", Map.of("username", other)));

            return List.of(
                "MeetBot: Google Meet with @" + name +
                ", and " + other +
                " starting at https://meet.google.com/abc-def-123"
            );
        }
    }

    // ------------------------------------------------------------------
    // TacoBot
    // ------------------------------------------------------------------
    public static class TacoBot implements Bot {
        private final Map<String, Integer> tacoCounts = new HashMap<>();
        private final EventBus eventBus;

        public TacoBot(EventBus eventBus) {
            this.eventBus = eventBus;
        }

        @Override
        public boolean shouldActivate(String name, String msg) {
            return msg.startsWith("/givetaco ");
        }

        @Override
        public List<String> execute(String name, String msg) {
            String[] parts = msg.split(" ");
            if (parts.length < 3) return List.of();

            String tacos = parts[1];
            String recipient = parts[2];
            int count = tacos.codePointCount(0, tacos.length());
            String user = recipient.startsWith("@") ? recipient.substring(1) : recipient;

            tacoCounts.put(user, tacoCounts.getOrDefault(user, 0) + count);

            return List.of(
                "TacoBot: @" + name + " gave @" + recipient + " " +
                count + " 🌮's. " + recipient +
                " now have " + tacoCounts.get(user) + " 🌮s."
            );
        }
    }

    // ------------------------------------------------------------------
    // ChatRoom
    // ------------------------------------------------------------------
    public static class ChatRoom {
        public final EventBus eventBus = new EventBus();
        private final List<Bot> bots = new ArrayList<>();
        private final List<String> messages = new ArrayList<>();

        public void register(Bot bot) {
            bots.add(bot);
        }

        public void sendMessage(String name, String msg) {
            messages.add(name + ": " + msg);

            for (Bot bot : bots) {
                if (bot.shouldActivate(name, msg)) {
                    messages.addAll(bot.execute(name, msg));
                }
            }
        }

        public List<String> getMessages() {
            return Collections.unmodifiableList(messages);
        }
    }
}