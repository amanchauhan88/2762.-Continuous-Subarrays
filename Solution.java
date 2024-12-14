import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        // Initialize a TreeMap to keep track of the frequency of elements in the window
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int left = 0; // Left pointer of the sliding window
        long count = 0; // Total count of continuous subarrays

        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            // Add the current element to the TreeMap
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Ensure the condition 0 <= |nums[i1] - nums[i2]| <= 2 is maintained
            while (map.lastKey() - map.firstKey() > 2) {
                // Shrink the window from the left
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            // Add the number of valid subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }
}
