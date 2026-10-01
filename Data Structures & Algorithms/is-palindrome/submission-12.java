class Solution {
    public boolean isPalindrome(String s) {
        int front = 0;
        int back = s.length() - 1;
        while(front <= back){
            if(!Character.isLetterOrDigit(s.charAt(front))) front++;
            else if(!Character.isLetterOrDigit(s.charAt(back))) back--;
            else{
                if(s.toLowerCase().charAt(front) != s.toLowerCase().charAt(back)){
                return false;
            }
            front++;
            back--;
            } 
            }
        return true;
    }
}
