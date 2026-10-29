class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
                if(tokens[i].equals("+")){
                    st.push(st.pop()+ st.pop());
                }
                else if(tokens[i].equals("-")){
                    int second = st.pop();
                    int first = st.pop();
                    st.push(first - second);            
                }
                else if(tokens[i].equals("/")){
                    int second = st.pop();
                    int first = st.pop();
                    st.push(first / second); 
                }
                else if(tokens[i].equals("*")){
                    st.push(st.pop() * st.pop());
                }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
