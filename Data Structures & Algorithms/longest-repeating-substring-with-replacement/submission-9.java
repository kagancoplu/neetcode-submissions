class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int res = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            hmap.put(s.charAt(r),hmap.getOrDefault(s.charAt(r),0)+ 1);
        
        while(((r - l  + 1) - (Collections.max(hmap.values())))> k){
            hmap.put(s.charAt(l), hmap.getOrDefault(s.charAt(l), 0) - 1) ;
            l++;
        }
        res = Math.max(res, r - l + 1); 
        }
        return res;
    }
}
 