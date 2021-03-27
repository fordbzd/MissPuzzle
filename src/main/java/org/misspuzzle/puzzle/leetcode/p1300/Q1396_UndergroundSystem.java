package org.misspuzzle.puzzle.leetcode.p1300;

import java.util.HashMap;
import java.util.Map;

public class Q1396_UndergroundSystem {

    private final Map<Integer, Travel> record;
    private final Map<String, Map<String, TimeSum>> time;

    public Q1396_UndergroundSystem() {
        record = new HashMap<>();
        time = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        record.put(id, new Travel(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Travel travel = record.get(id);
        record.remove(id);

        if (!time.containsKey(travel.stationName)) {
            time.put(travel.stationName, new HashMap<>());
        }

        Map<String, TimeSum> stationMap = time.get(travel.stationName);

        if (!stationMap.containsKey(stationName)) {
            stationMap.put(stationName, new TimeSum(0, 0));
        }

        TimeSum timeSum = stationMap.get(stationName);
        timeSum.sum += t - travel.checkInTime;
        timeSum.count++;
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<String, TimeSum> stationMap = time.get(startStation);
        TimeSum timeSum = stationMap.get(endStation);

        return timeSum.sum / (double)timeSum.count;
    }

    private static class Travel {
        String stationName;
        int checkInTime;

        public Travel(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private static class TimeSum {
        int sum;
        int count;

        TimeSum(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
