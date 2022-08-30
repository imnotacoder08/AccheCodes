class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] idx = {0, 0};
        HashMap<Integer, Integer> numIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            numIdxMap.put(nums[i], i);
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            boolean hasDiffIdx = numIdxMap.containsKey(diff);
            if (hasDiffIdx) {
                int diffIdx = numIdxMap.get(diff);
                if (diffIdx != i) {
                    idx[0] = i;
                    idx[1] = diffIdx;
                    break;
                }
            }
        }
        
        return idx;
    }
}