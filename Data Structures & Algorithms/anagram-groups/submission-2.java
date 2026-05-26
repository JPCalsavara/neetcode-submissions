class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }

            String signature = Arrays.toString(count);

            
            anagrams.putIfAbsent(signature, new ArrayList<>());
            
            
            anagrams.get(signature).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    
}
