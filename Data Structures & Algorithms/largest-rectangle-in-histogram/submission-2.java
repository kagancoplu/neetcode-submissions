class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < heights.length;i++){
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]){
                int[] top = st.pop();
                int index = top[0];
                int height = top[1];
                max = Math.max(max,(height * (i - index)));
                start = index;
            }
            st.push(new int[]{start,heights[i]});
    }
    for(int[] c : st){
        max = Math.max(max,c[1] * (heights.length - c[0]));
    }
    return max;
}
}
