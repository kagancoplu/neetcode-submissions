class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr = s1.toCharArray();
        int front = 0;
        int back = arr.length - 1;
        while(front <= back){
            if(arr[front] != arr[back]){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
