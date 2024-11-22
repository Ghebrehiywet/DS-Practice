import static SlidingWindow.ConsecutiveOnes.numberOfWays;

public class Main {
    public static void main(String[] args) {
//        String s = "abcdeffg";
//        System.out.println(longestSubstringKDistinct(s, 3));
//        int[] input = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
//        System.out.println(findMaxSumSubarray(input, 3));
//        int[] input = {4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
//        System.out.println(findSmallestSubarray(input, 8));

//        String input = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(input));
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(numberOfWays(arr, 6));
    }
}