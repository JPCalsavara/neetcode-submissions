class Solution {
    public int missingNumber(int[] nums) {
        // [1,2,3]
        // max = nums.length - 1
        // [3,1,2]

        int sum = 0;

        for(int i = 0; i < nums.length + 1; i++){
            sum += i;
        }

        for(int i = 0; i < nums.length; i++){
            sum -= nums[i];
        }

        return sum;
    }
}
