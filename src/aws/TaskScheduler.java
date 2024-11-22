package aws;

import java.util.HashMap;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (Character task : tasks) {
            charFreq.put(task, charFreq.getOrDefault(task, 0) + 1);
        }

        int maxFreq = 0;
        for (Character c : charFreq.keySet()) {
            if (charFreq.get(c) > maxFreq)
                maxFreq = charFreq.get(c);
        }

        int maxFreqOccurances = 0;
        for (Character c : charFreq.keySet()) {
            if (charFreq.get(c) == maxFreq)
                maxFreqOccurances++;
        }

        int minInterval = (maxFreq - 1) * (n + 1) + maxFreqOccurances;
        return Math.max(minInterval, tasks.length);
    }
}
