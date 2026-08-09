package org.misspuzzle.puzzle.gpt;

import java.util.*;

public class SocialNetwork {

    // follower → (followee → timestamp)
    Map<String, Map<String, Integer>> db;

    SocialNetwork() {
        db = new HashMap<>();
    }

    public void follow(String follower, String followee, int timestamp) {
        if (follower.equals(followee)) {
            return;
        }

        db.computeIfAbsent(follower, k -> new HashMap<>()).put(followee, timestamp);
    }

    public boolean check(String follower, String followee, int timestamp) {
        if (!db.containsKey(follower)) {
            return false;
        }

        Map<String, Integer> list = db.get(follower);
        if (!list.containsKey(followee)) {
            return false;
        }

        return list.get(followee) <= timestamp;
    }

    public List<String> recommend(String user){
        if (!db.containsKey(user)) {
            return List.of();
        }

        Map<String, Integer> myFollowees = db.get(user);
        
        Map<String, Integer> rank = new HashMap<>();
        for (String mid : myFollowees.keySet()) {
            Map<String, Integer> friends = db.getOrDefault(mid, Map.of());

            for (String friend : friends.keySet()) {
                if (!friend.equals(user) && !myFollowees.containsKey(friend)) {
                    rank.put(friend, rank.getOrDefault(friend, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(rank.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<String> result = new ArrayList<>();
        for (var e : entries) {
            result.add(e.getKey());
        }

        return result;
    }
}