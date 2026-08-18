package org.misspuzzle.puzzle.gpt;

import java.util.ArrayList;
import java.util.List;

public class LabelingScheduler {

    record Assignment (
        int task,
        int model,
        int human
    ) {}

    public List<Assignment> buildBalancedSchedule(int t, int m, int h, int k) {
        if (k == 0) {
            return List.of();
        }

        if (t <= 0 || m <= 0 || h <= 0 || k < 0 || t < k) {
            return null;
        }

        int[] count = new int[t];
        List<Assignment> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < h; j++) {
                int task = (j + i) % t;
                result.add(new Assignment(task, count[task]++ % m, j));
            }
        }

        return result;
    }  

    public List<Assignment> buildFullyBalancedSchedule(int t, int m, int h, int k) {
        if (k == 0) return List.of();
        if (t <= 0 || m <= 0 || h <= 0 || k < 0 || k > t) return null;

        final int N = h * k;
        boolean[][] used = new boolean[h][t];
        int[] humanCnt = new int[h];
        int[][] taskModelCnt = new int[t][m];
        int[][] taskHumanCnt = new int[t][h];
        int[][] modelHumanCnt = new int[m][h];

        List<Assignment> result = new ArrayList<>(N);

        for (int step = 0; step < N; step++) {
            Assignment best = null;
            int bestTM = Integer.MAX_VALUE;
            int bestTH = Integer.MAX_VALUE;
            int bestMH = Integer.MAX_VALUE;

            // Brute-force scan of all possible triples
            for (int human = 0; human < h; human++) {
                if (humanCnt[human] == k) continue;

                for (int task = 0; task < t; task++) {
                    if (used[human][task]) continue;

                    for (int model = 0; model < m; model++) {
                        int tm = taskModelCnt[task][model];
                        int th = taskHumanCnt[task][human];
                        int mh = modelHumanCnt[model][human];

                        // lexicographical minimum
                        if (tm < bestTM
                                || (tm == bestTM && th < bestTH)
                                || (tm == bestTM && th == bestTH && mh < bestMH)) {
                            bestTM = tm;
                            bestTH = th;
                            bestMH = mh;
                            best = new Assignment(task, model, human);
                        }
                    }
                }
            }

            if (best == null) {
                // Should never happen when k <= t
                return null;
            }

            // Commit the chosen triple
            int task = best.task();
            int model = best.model();
            int human = best.human();

            result.add(best);
            used[human][task] = true;
            humanCnt[human]++;
            taskModelCnt[task][model]++;
            taskHumanCnt[task][human]++;
            modelHumanCnt[model][human]++;
        }

        return result;
    }
}
