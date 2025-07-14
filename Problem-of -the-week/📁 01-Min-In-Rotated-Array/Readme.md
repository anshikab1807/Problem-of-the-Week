# Find Minimum in Rotated Sorted Array

This project provides a solution to the classic algorithm problem of finding the minimum element in a rotated sorted array.

## Problem Description

Suppose an array of length `n` sorted in ascending order is rotated at some pivot unknown to you beforehand. For example, the array `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]` if it was rotated 4 times. Given such a rotated sorted array `nums` of unique elements, the task is to return the minimum element of this array. The solution should aim for an optimal time complexity, ideally O(log n).

## Approach

The problem can be efficiently solved using a modified binary search approach. The key idea is to leverage the sorted nature of the array segments created by the rotation.

1.  **Initialize Pointers:** Use two pointers, `low` and `high`, representing the start and end of the search range.
2.  **Handle Unrotated Case:** If `nums[low] < nums[high]`, the array is not rotated, and `nums[low]` is the minimum.
3.  **Binary Search Iteration:** While `low <= high`:
    *   Calculate the middle index: `mid = low + (high - low) // 2`.
    *   **Identify the Sorted Half:**
        *   If `nums[mid] > nums[high]`, the minimum element must be in the right half (the unsorted part), so `low = mid + 1`.
        *   If `nums[mid] < nums[high]`, the minimum element is in the left half (including `mid`), so `high = mid`.
        *   If `nums[mid] == nums[high]` (for arrays with duplicates, though this problem often assumes unique elements), decrement `high` to narrow the search space.
4.  **Return Minimum:** After the loop terminates, `nums[low]` will be the minimum element.

## Usage

To use this solution, you can typically call a function with the rotated sorted array as an argument.

```python
# Example Usage (Python)
def findMin(nums: list[int]) -> int:
    # ... (implementation of the binary search logic described above)
    pass

rotated_array = [4, 5, 6, 7, 0, 1, 2]
minimum_element = findMin(rotated_array)
print(f"The minimum element is: {minimum_element}") # Output: The minimum element is: 0