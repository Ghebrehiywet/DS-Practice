package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class RepeatingCharacterReplacement {
    //    424. Longest Repeating Character Replacement
    public int characterReplacement(String s, int k) {
        int maxLen = 0, n = s.length();
        int L = 0, R = 0, mostFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (R < n) {
            char elem = s.charAt(R);
            map.put(elem, map.getOrDefault(elem, 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(elem));

            if ((R - L + 1) - mostFreq > k) {
                map.put(s.charAt(L), map.get(s.charAt(L)) - 1);
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
            R++;
        }
        return maxLen;
    }

}
