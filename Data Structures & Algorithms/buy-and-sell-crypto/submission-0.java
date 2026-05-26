class Solution {
    public int maxProfit(int[] prices) {
        int lowerPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(price < lowerPrice){
                lowerPrice = price;
            } else{
                int profit = price - lowerPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
