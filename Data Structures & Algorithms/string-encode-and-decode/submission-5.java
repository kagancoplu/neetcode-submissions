class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String cur : strs){
            sb.append(cur.length()).append("#").append(cur);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = str.indexOf("#", i);
            int len = Integer.parseInt(str.substring(i,j));
            res.add(str.substring(j + 1, j + 1 + len));  
            i = j + len + 1;
        }
        return res;
    }
}
