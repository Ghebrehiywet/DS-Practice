package intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastElem = result.getLast();
            if (lastElem[1] >= intervals[i][0]) {
                lastElem[1] = Math.max(lastElem[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
