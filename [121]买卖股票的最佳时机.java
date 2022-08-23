

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //最大利润
        int maxProfit = 0;
        //买入股票时的最低价
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {

            //找出最低的股票价格
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }

            //获取最大的利润
            if(prices[i]-minPrice >maxProfit){
                maxProfit = prices[i]-minPrice;
            }
        }

        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
