package aws;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TrackMaximumUnits {
    //    1710. Maximum Units on a Truck
    public int maximumUnits1(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingDouble(b -> b[1]));
        int n = boxTypes.length;
        int remBoxCount = truckSize;
        int itemsCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (remBoxCount >= boxTypes[i][0]) {
                itemsCount += boxTypes[i][0] * boxTypes[i][1];
                remBoxCount -= boxTypes[i][0];
            } else {
                itemsCount += remBoxCount * boxTypes[i][1];
                break;
            }
        }
        return itemsCount;
    }

    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        queue.addAll(Arrays.asList(boxTypes));
        int currentSize = 0;
        int itemsCount = 0;
        while (!queue.isEmpty() && currentSize < truckSize) {
            int[] box = queue.poll();
            int remainingSlot = truckSize - currentSize;
            int boxesCanFit = Math.min(remainingSlot, box[0]);
            currentSize += boxesCanFit;
            itemsCount += box[1] * boxesCanFit;
        }
        return itemsCount;
    }
}
