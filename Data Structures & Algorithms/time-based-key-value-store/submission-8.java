class TimeMap {
    HashMap<String,List<Integer>> times;
    HashMap<String,List<String>> values;
    public TimeMap() {
        times = new HashMap<>();
        values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        times.computeIfAbsent(key,k -> new ArrayList<>()).add(timestamp);
        values.computeIfAbsent(key,k -> new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> list = times.get(key);
        if(list == null) return "";
        List<String> strs = values.get(key);
        String res = "";
        int l = 0;
        int r = list.size() - 1;
        while(l<= r){
            int mid = l + (r - l) / 2;
            if(list.get(mid) <= timestamp){
                res = strs.get(mid);
                l = mid + 1;
            }
            else {
                r = mid -1;
            }
        }
         return res; 
    }
}
