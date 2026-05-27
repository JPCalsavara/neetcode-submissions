class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        int min = nums[0];

        //[3,4,5,6,1,2]
        // l = 0 , r = 5, mid = 2
        while(l <= r){
            int left = nums[l];
            int right = nums[r];

            if(left < right){
                min = Math.min(min,left);
                break;
            }
            int m = l + (r - l) / 2;

            int mid = nums[m];

            min = Math.min(mid,min);

            if(left <= mid){
               l = m + 1;
            } else{
                r = m - 1;
            }
        }

        return min;
    }
}
