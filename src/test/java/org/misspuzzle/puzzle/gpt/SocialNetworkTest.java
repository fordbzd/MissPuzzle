package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SocialNetworkTest {

    @Test
    public void testBasicFollowAndCheck() {
        SocialNetwork sn = new SocialNetwork();

        sn.follow("alice", "bob", 10);
        sn.follow("alice", "carol", 20);

        // Edge exists after its timestamp
        assertTrue(sn.check("alice", "bob", 15));
        assertTrue(sn.check("alice", "bob", 10));
        assertTrue(sn.check("alice", "carol", 25));

        // Edge does not exist before its timestamp
        assertFalse(sn.check("alice", "bob", 5));
        assertFalse(sn.check("alice", "carol", 15));

        // Direction matters
        assertFalse(sn.check("bob", "alice", 30));

        // Non-existent users
        assertFalse(sn.check("alice", "dave", 100));
        assertFalse(sn.check("unknown", "alice", 100));
    }

    @Test
    public void testRecommendBasic() {
        SocialNetwork sn = new SocialNetwork();

        // alice → bob → david
        // alice → bob → eve
        // alice → carol → david
        // alice → carol → frank
        sn.follow("alice", "bob", 1);
        sn.follow("alice", "carol", 2);
        sn.follow("bob", "david", 3);
        sn.follow("bob", "eve", 4);
        sn.follow("carol", "david", 5);
        sn.follow("carol", "frank", 6);

        List<String> result = sn.recommend("alice");

        // david has 2 intermediaries (bob & carol)
        // eve and frank have 1 each
        assertEquals(3, result.size());
        assertEquals("david", result.get(0));          // highest count first

        // The remaining two can be in any order
        Set<String> rest = new HashSet<>(result.subList(1, 3));
        assertTrue(rest.contains("eve"));
        assertTrue(rest.contains("frank"));
    }

    @Test
    public void testRecommendNoCandidates() {
        SocialNetwork sn = new SocialNetwork();

        sn.follow("alice", "bob", 1);
        // bob follows nobody

        List<String> result = sn.recommend("alice");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testRecommendAlreadyFollowing() {
        SocialNetwork sn = new SocialNetwork();

        sn.follow("alice", "bob", 1);
        sn.follow("bob", "carol", 2);
        sn.follow("alice", "carol", 3);   // alice already follows carol

        List<String> result = sn.recommend("alice");
        assertTrue(result.isEmpty());    // carol must not be recommended
    }

    @Test
    public void testRecommendExcludeSelf() {
        SocialNetwork sn = new SocialNetwork();

        sn.follow("alice", "bob", 1);
        sn.follow("bob", "alice", 2);     // bob follows alice

        List<String> result = sn.recommend("alice");
        assertTrue(result.isEmpty());    // alice must not recommend herself
    }

    @Test
    public void testRecommendEmptyNetwork() {
        SocialNetwork sn = new SocialNetwork();
        List<String> result = sn.recommend("alice");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultipleIntermediariesRanking() {
        SocialNetwork sn = new SocialNetwork();

        // alice follows three people, all of whom follow "target"
        sn.follow("alice", "x", 1);
        sn.follow("alice", "y", 2);
        sn.follow("alice", "z", 3);

        sn.follow("x", "target", 4);
        sn.follow("y", "target", 5);
        sn.follow("z", "target", 6);

        // also a single path to "other"
        sn.follow("x", "other", 7);

        List<String> result = sn.recommend("alice");

        assertEquals(2, result.size());
        assertEquals("target", result.get(0));   // 3 intermediaries
        assertEquals("other", result.get(1));    // 1 intermediary
    }
}
