class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res,0);
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            int t= temperatures[i];
            while(!st.isEmpty() && t > st.peek()[0]){
                int stacki = st.pop()[1];
                res[stacki] = i - stacki;
            }
            st.push(new int[]{t,i});
        }
        return res;
    }
}
