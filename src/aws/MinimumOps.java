package aws;

import java.util.HashSet;

public class MinimumOps {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.add(nums[i]);
            }
        }
        return map.size();
    }

}
