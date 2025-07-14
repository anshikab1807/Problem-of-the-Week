import java.util.HashMap;

public class HashMapOptimized {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); 

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            if (prefixSumFreq.containsKey(prefixSum - k)) {
                count += prefixSumFreq.get(prefixSum - k);
            }

            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySum(nums, k)); // Output: 2
    }
}
