package aws;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringManipulation {
    //    767. Reorganize String
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        queue.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;
        while (queue.size() > 1) {
            var first = queue.poll();
            var second = queue.poll();

            result.append(first.getKey());
            result.append(second.getKey());

            first.setValue(first.getValue() - 1);
            second.setValue(second.getValue() - 1);

            if (first.getValue() > 0) {
                queue.add(first);
            }
            if (second.getValue() > 0) {
                queue.add(second);
            }
        }
        if (!queue.isEmpty()) {
            var elem = queue.poll();
            if (elem.getValue() > 1) {
                return "";
            }
            result.append(elem.getKey());
        }

        return result.toString();
    }
}
