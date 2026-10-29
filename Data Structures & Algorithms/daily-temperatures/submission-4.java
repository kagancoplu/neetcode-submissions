class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
                while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                    int index = st.pop();
                    res[index] = i - index;
                }
            st.push(i);
        }
        while(!st.isEmpty()){
            res[st.pop()]  = 0;
        }
        return res;
    }
}
