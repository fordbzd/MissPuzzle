package org.misspuzzle.puzzle.gpt;

import java.util.*;

public class GPUCredit {

    // ------------------------------------------------------------------
    // Event
    // ------------------------------------------------------------------
    private static class Event {
        final boolean isAdd;
        final String creditId;
        final int amount;
        final int timestamp;
        final int expiration; // duration (only for add)

        private Event(boolean isAdd, String creditId, int amount, int timestamp, int expiration) {
            this.isAdd = isAdd;
            this.creditId = creditId;
            this.amount = amount;
            this.timestamp = timestamp;
            this.expiration = expiration;
        }

        static Event add(String id, int amount, int ts, int exp) {
            return new Event(true, id, amount, ts, exp);
        }

        static Event sub(int amount, int ts) {
            return new Event(false, null, amount, ts, 0);
        }
    }

    // ------------------------------------------------------------------
    // Grant (for the heap)
    // ------------------------------------------------------------------
    private static class Grant {
        final String id;
        final int expireAt;   // absolute expiration time (inclusive)
        int remaining;

        Grant(String id, int amount, int expireAt) {
            this.id = id;
            this.remaining = amount;
            this.expireAt = expireAt;
        }
    }

    private final List<Event> events = new ArrayList<>();

    // ------------------------------------------------------------------
    // Public API
    // ------------------------------------------------------------------
    public void addCredit(String creditId, int amount, int timestamp, int expiration) {
        events.add(Event.add(creditId, amount, timestamp, expiration));
    }

    public void subtract(int amount, int timestamp) {
        events.add(Event.sub(amount, timestamp));
    }

    public Integer getBalance(int queryTime) {
        // 1. Collect & sort relevant events
        List<Event> relevant = new ArrayList<>();
        for (Event e : events) {
            if (e.timestamp <= queryTime) {
                relevant.add(e);
            }
        }
        relevant.sort(Comparator.comparingInt(e -> e.timestamp));

        // 2. Replay with a min-heap (earliest expiration first)
        // Heap ordered by expireAt
        PriorityQueue<Grant> heap = new PriorityQueue<>(Comparator.comparingInt(g -> g.expireAt));
        Map<String, Grant> active = new HashMap<>(); // id → Grant (for quick lookup)
        int negative = 0; // accumulated over-burn

        for (Event e : relevant) {
            if (e.isAdd) {
                int expireAt = e.timestamp + e.expiration;
                Grant g = new Grant(e.creditId, e.amount, expireAt);
                heap.offer(g);
                active.put(e.creditId, g);
            } else {
                // subtract – burn from earliest-expiring active grants
                int need = e.amount;

                while (need > 0 && !heap.isEmpty()) {
                    Grant g = heap.peek();

                    // Skip grants that are already expired at the time of this subtract
                    // or have no remaining credit
                    if (g.expireAt < e.timestamp || g.remaining <= 0) {
                        heap.poll();
                        active.remove(g.id);
                        continue;
                    }

                    int take = Math.min(need, g.remaining);
                    g.remaining -= take;
                    need -= take;

                    if (g.remaining == 0) {
                        heap.poll();
                        active.remove(g.id);
                    }
                }

                // Still need more → goes negative
                if (need > 0) {
                    negative += need;
                }
            }
        }

        // 3. Sum remaining credit of grants still valid at queryTime
        int balance = -negative;
        for (Grant g : active.values()) {
            if (g.expireAt >= queryTime && g.remaining > 0) {
                balance += g.remaining;
            }
        }

        return balance < 0 ? null : balance;
    }
}