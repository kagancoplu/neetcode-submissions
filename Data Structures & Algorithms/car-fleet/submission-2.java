class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> tmap = new TreeMap<>(Collections.reverseOrder());
        Stack<Double> st = new Stack<>();
        int i = 0;
        for(int pos : position){
            tmap.put(pos,speed[i++]);
        }
        for(Map.Entry<Integer,Integer> entry : tmap.entrySet()){
            double left = (double)(target - entry.getKey()) / entry.getValue();
            if(st.isEmpty() || left > st.peek()){
                st.push(left);
            }
        }
        return st.size();
    }
}
