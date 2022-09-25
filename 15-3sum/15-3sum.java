class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // sort the array
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++) {
            //set left most and right most pointer
            int left = i+1;
            int right = nums.length -1;
            // skip the duplicated to avoid same result
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // we need both left and right, so cannot =
            while(left < right) {
                int temp = nums[left] + nums[right];
                if(temp + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    // skip the same element when adding into result. Avoid adding same result
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    right--;
                }
                else if(temp + nums[i] < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return res;
    }
    
}