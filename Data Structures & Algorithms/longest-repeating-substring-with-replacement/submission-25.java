class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int res = 0;
        int maxf= 0;
        for(int r = 0; r < s.length(); r++){
            int c = s.charAt(r) - 'A';
            count[c]++;
            maxf = Math.max(maxf, count[c]);
            while((r - l + 1) - maxf > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r- l + 1);
        }
        return res;
    }
}
 