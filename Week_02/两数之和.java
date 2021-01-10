class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                return new int[]{i, mp.get(nums[i])};
            }
            mp.put(target - nums[i], i);
        }
        return null;
    }
}