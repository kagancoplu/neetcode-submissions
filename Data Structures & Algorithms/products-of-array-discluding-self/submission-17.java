class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prod = 1;
        int zero = 0;
        int zeroindex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zero++;
                zeroindex = i;
                continue;
            }
            prod *= nums[i];
        }
        if(zero >= 2){
            for(int i = 0; i < res.length; i++){
                res[i] = 0;
        }
        }
        else if(zero == 1){
            for(int i = 0; i < res.length; i++){
                if(i == zeroindex){
                    res[i] = prod;
                }
                else{
                    res[i] = 0;
                }
            }
        }
        else{
            for(int i = 0; i < res.length; i++){
                res[i] = prod / nums[i];
            }
        }
        return res;
    }
}  
