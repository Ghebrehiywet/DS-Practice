package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    //    Longest Substring with At Most K Distinct Characters
    public static int longestSubstringKDistinct(String input, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int length = 0, start = 0;

        for (int i = 0; i < input.length(); i++) {
            char elem = input.charAt(i);
            freq.put(elem, freq.getOrDefault(elem, 0) + 1);
            while (freq.size() > k) {
                char leftChar = input.charAt(start);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                start++;
            }
            length = Math.max(length, i - start + 1);
        }
        return length;
    }

    //    Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int maxLen = 0;
        int L = 0, R = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (R < n) {
            map.put(arr[R], map.getOrDefault(arr[R], 0) + 1);
            while (map.size() != R - L + 1) {
                map.put(arr[L], map.get(arr[L]) - 1);
                if (map.get(arr[L]) == 0) {
                    map.remove(arr[L]);
                }
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
            R++;
        }
        return maxLen;
    }
}
