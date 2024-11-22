package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class ConsecutiveOnes {
    //    485. Max Consecutive Ones
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        int R = 0;
        int count = 0;
        while (R < n) {
            if (nums[R] == 1) {
                count++;
            } else {
                count = 0;
            }
            maxLen = Math.max(maxLen, count);
            R++;
        }
        return maxLen;
    }

    //    487: Max Consecutive Ones II
    public static int findMaxConsecutiveOnesByReplacingOneZero(int[] nums) {
        int maxLen = 0;
        int L = 0, R = 0;
        int zeroCounter = 0;
        int n = nums.length;
        while (R < n) {
            if (nums[R] == 0) {
                zeroCounter++;
            }
            while (zeroCounter > 1) {
                if (nums[L] == 0) {
                    zeroCounter--;
                }
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
            R++;
        }
        return maxLen;
    }

    public static int numberOfWays(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int item : arr) {
            if (map.containsKey(item)) {
                counter++;
                var elem = map.get(item);
                System.out.println(elem + "+" + item);
            }
            map.put(k - item, item);
        }
        return counter;
    }
}
