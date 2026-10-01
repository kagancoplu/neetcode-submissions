class Solution {
    public int trap(int[] height) {
        int stored = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minlr = new int[height.length];
        maxLeft[0] = 0;
        maxRight[height.length - 1] = 0;
        for(int i = 1; i < height.length; i++){
            maxLeft[i] = Math.max(height[i-1],maxLeft[i-1]);
        }
        for(int i = maxRight.length - 2; i >= 0;i-- ){
            maxRight[i] = Math.max(height[i+1],maxRight[i+1]);
        }
        for(int i =0; i < minlr.length; i++){
            if(Math.min(maxLeft[i],maxRight[i])-height[i] > 0){
            stored +=Math.min(maxLeft[i],maxRight[i])-height[i];
            }
        }
        return stored;
    }
}
