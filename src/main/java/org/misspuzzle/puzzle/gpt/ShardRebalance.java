package org.misspuzzle.puzzle.gpt;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ShardRebalance {
    public static class Shard {
        String id;
        int start;
        int end;

        public Shard(String id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return id + ":" + start + ":" + end;
        }
    }

    public List<String> rebalance(int limit, List<String> input) {
        if (limit < 1 || input == null || input.size() == 0) {
            return List.of();
        }

        List<Shard> shards = new ArrayList<>();
        for (var shardStr : input) {
            String[] shardStrs = shardStr.split(":");
            shards.add(new Shard(shardStrs[0], Integer.parseInt(shardStrs[1]), Integer.parseInt(shardStrs[2])));
        }
        
        shards.sort((a, b) -> {
            // return a.start == b.start ? (a.end - b.end) : (a.start - b.start);
            return a.start - b.start;
        });

        List<Shard> toKeep = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Find out of limit
        for (var shard : shards) {
            int currStart = shard.start;

            while (pq.size() > 0 && pq.peek() < currStart) {
                pq.poll();
            }

            if (pq.size() >= limit) {
                currStart = pq.peek() + 1;
            }

            if (currStart > shard.end) {
                continue;
            }

            shard.start = currStart;
            toKeep.add(shard);
            pq.add(shard.end);

            while (pq.size() > 0 && pq.peek() < currStart) {
                pq.poll();
            }
        }

        // Fill gap
        for (int i = 1; i < toKeep.size(); i++) {
            if (toKeep.get(i).start - 1 > toKeep.get(i - 1).end) {
                toKeep.get(i - 1).end = toKeep.get(i).start - 1;
            }
        }

        // Build result
        return toKeep.stream().map(k -> k.toString()).toList();
    }
}
