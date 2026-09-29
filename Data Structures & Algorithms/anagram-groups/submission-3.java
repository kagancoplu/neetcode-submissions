class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> sorted = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sorted.computeIfAbsent(new String(chars),x -> new ArrayList<>()).add(strs[i]); 
        }
        return new ArrayList<>(sorted.values());
    }
}
