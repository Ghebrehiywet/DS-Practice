package SlidingWindow;

public class SmallestSubArray {
    //  Smallest subarray with a given sum
    public static int findSmallestSubarray(int[] arr, int sum) {
        int subarrayLen = Integer.MAX_VALUE;
        int currSum = 0, left = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            while (currSum >= sum) {
                subarrayLen = Math.min(subarrayLen, i - left + 1);
                currSum -= arr[left];
                left++;
            }
        }
        return subarrayLen;
    }
}
