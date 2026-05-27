class Solution {
    public int missingNumber(int[] nums) {
        // [1,2,3]
        // max = nums.length - 1

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i == nums[i]){
               continue;
            } else{
                return i;
            }
        }

        return nums.length;
    }
}
