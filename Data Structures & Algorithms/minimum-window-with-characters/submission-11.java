class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()|| t.equals("")) return "";
        HashMap<Character,Integer> tcount = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(int i  = 0; i < t.length(); i++){
            tcount.put(t.charAt(i),tcount.getOrDefault(t.charAt(i),0) + 1);
        }
        int have = 0;
        int need = tcount.size();
        int[] res = new int[2];
        int reslength = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r),0) + 1);
            if(tcount.containsKey(s.charAt(r)) && window.get(s.charAt(r)).equals(tcount.get(s.charAt(r)))){
                have++;
            }
            while(have == need){
                if(r - l + 1 < reslength){
                    res = new int[]{l,r};
                    reslength = r - l + 1;
                }
                window.put(s.charAt(l),window.get(s.charAt(l)) - 1);
                if (tcount.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < tcount.get(s.charAt(l))){
                    have--;
                }          
                l++;  
            }
            
        }
        if(reslength != Integer.MAX_VALUE) return s.substring(res[0],res[1] + 1); else return "";
    }
}
