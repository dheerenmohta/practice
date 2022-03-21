class Solution {
    public int maxProfit(int[] prices) {
     
        int n = prices.length;
        
        int sp = 0;
        int maxProfit = 0;
        
        for(int i = n-1; i >=0; i--){
            sp = Math.max(sp,prices[i]);
            maxProfit = Math.max(sp-prices[i],maxProfit);
        }
        
        return maxProfit;
        
    }
}
