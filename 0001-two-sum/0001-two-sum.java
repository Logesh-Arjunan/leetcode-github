class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Use a HashMap to store the value and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number and index
            map.put(nums[i], i);
        }

        // If no solution found (LeetCode guarantees one solution)
        return new int[] {};
    }
}

