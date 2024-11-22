package monotonicstack;

import java.util.Stack;

public class DailyTemperature {
    //    739. Daily Temperatures
    //    Input: temperatures = [73,74,75,71,69,72,76,73]
    //    Output: [1,1,4,2,1,1,0,0]
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
