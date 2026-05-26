class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSizeSubtring = 0;

        Set<Character> visited = new HashSet<>();

        int l = 0;
        int r = 0;

        while(r < s.length()){
            char rightChar = s.charAt(r);
            char leftChar = s.charAt(l);
            
            while(visited.contains(rightChar)){
                visited.remove(leftChar);
                l++;
                leftChar = s.charAt(l);
            }
           
            visited.add(rightChar);
               
            int size = r - l + 1;
            maxSizeSubtring = Math.max(maxSizeSubtring, size);
            r++;
        }

        return maxSizeSubtring;
    }
}
