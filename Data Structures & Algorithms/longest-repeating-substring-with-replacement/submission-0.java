class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> count = new HashMap<>();


        int l = 0, maxf = 0, res = 0;
       for(int r = 0; r < s.length(); r++){
        char letter = s.charAt(r);
        count.put(letter,count.getOrDefault(letter,0) + 1);
        maxf = Math.max(maxf, count.getOrDefault(letter, 0));

        while((r - l + 1) - maxf > k){
            letter = s.charAt(l);
            count.put(letter, count.get(letter) - 1);
            l++;
        }

        res = Math.max(res, r - l + 1);
       } 
       
       return res;
    }
}

//"XYYXX"
