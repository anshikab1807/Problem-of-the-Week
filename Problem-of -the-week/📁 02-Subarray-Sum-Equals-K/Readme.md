## Solution Approach

The solution utilizes the **Prefix Sum with Hash Map** approach for optimal time complexity.

1.  **Prefix Sum:** Maintain a running sum (`currentSum`) as you iterate through the array.
2.  **Hash Map:** Use a `HashMap` to store the frequency of each prefix sum encountered so far. The key will be the prefix sum, and the value will be its frequency.
3.  **Calculation:** For each element, calculate `currentSum`. Then, check if `currentSum - k` exists in the `HashMap`. If it does, it means there are `map.get(currentSum - k)` subarrays ending at the current index whose sum equals `k`. Add this count to the total.
4.  **Update Map:** After processing the current element, add `currentSum` to the `HashMap` or increment its frequency if it already exists. Initialize `map.put(0, 1)` to handle cases where a subarray starting from index 0 sums to `k`.
