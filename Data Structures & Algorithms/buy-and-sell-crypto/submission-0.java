class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int i=0;
        int j=1;

        while(j< prices.length){
            if(prices[j] < prices[i]){
                i++;
            }else{
            maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            j++;
            }
             
           


        }
return maxProfit;

    }
}
