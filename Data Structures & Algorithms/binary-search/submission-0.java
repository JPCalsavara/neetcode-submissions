class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = (nums.length - 1) / 2;

        while(l <= r){
            if(nums[m] == target){
                return m;
            } else if(nums[m] < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
            m = l + (r - l) / 2;
        }

        return -1;
    }
}
