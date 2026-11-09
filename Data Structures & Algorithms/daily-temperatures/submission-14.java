class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();
        Arrays.fill(res, 0);
        for(int i = 0; i < temperatures.length; i++){
            int a = temperatures[i];
            while(!st.isEmpty() && a > st.peek()[0]){
                int[] arr = st.pop();
                int stackt = arr[0];
                int stacki = arr[1];
                res[stacki] = i -stacki;
            }
            st.push(new int[]{a,i});
        }
        return res;
    }
}
