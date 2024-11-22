package SlidingWindow;

public class MaxSum {
    //  Maximum sum of a contiguous subarray of size K
    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0, left = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= arr[left++];
            }
        }
        return maxSum;
    }
}
