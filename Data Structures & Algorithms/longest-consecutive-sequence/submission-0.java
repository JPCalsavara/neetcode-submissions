class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        Set<Integer> visited = new HashSet<>();
        int maxSize = 0;
        for(int n : nums){
            visited.add(n);
        }

        for(int num : visited){
            if(!visited.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while (visited.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxSize = Math.max(maxSize, currentStreak);
            }
        }
        return maxSize;
    }
}
