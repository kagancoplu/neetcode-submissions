class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src] = 0;
        for(int i = 0; i < k + 1; i++){
            int[] copy = prices.clone();
            for(int[] arr : flights){
                int s = arr[0],d = arr[1], p = arr[2];
                if(prices[s] == Integer.MAX_VALUE){
                    continue;
                }
                if(prices[s] + p < copy[d]){
                    copy[d] = prices[s] + p;
                }
            }
            prices = copy;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
