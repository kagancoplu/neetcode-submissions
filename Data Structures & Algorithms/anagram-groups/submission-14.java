class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            hmap.computeIfAbsent(new String(arr),k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(hmap.values());
    }
}
