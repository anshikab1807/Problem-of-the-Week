import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        prefixCount.put(0, 1);   
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixCount.containsKey(prefixSum - k)) {
                count += prefixCount.get(prefixSum - k);
            }
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}
