package SlidingWindow;

public class SubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length < target)
            return 0;

        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                int diff = i - left + 1;
                result = Math.min(result, diff);
                sum -= nums[left];
                left++;
            }
        }
        return result;
    }
}
