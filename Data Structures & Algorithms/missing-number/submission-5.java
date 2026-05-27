class Solution {
    public int missingNumber(int[] nums) {
        // [1,2,3]
        // max = nums.length - 1

        Set<Integer> set = new HashSet<>();

        int size = nums.length + 1;
        int[] counter = new int[size];

        for(int i = 0; i < nums.length; i++){
            counter[nums[i]] = 0;
        }

        for(int num : nums){
            counter[num]++;
        }

        for(int i = 0; i < nums.length; i++){
            if(counter[i] == 0){
               return i;
            }
        }

        return nums.length;
    }
}
