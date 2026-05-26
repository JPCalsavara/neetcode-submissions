class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String signature = new String(c);

            if(!anagrams.containsKey(signature)){
                anagrams.put(signature, new ArrayList<>());
            }
            
            anagrams.get(signature).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    
}
