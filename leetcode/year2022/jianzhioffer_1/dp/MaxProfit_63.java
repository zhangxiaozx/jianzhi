package leetcode.year2022.jianzhioffer_1.dp;

/**
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class MaxProfit_63 {
    public int maxProfit(int[] prices){
        int l = prices.length;
        if (l == 0) return 0;

        int maxProfit =0;
        int cost = prices[0];
        for (int i = 0; i < l; i++) {
            cost = Math.min(cost,prices[i]);

            maxProfit = Math.max(maxProfit,prices[i] - cost);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices){
        int l = prices.length;
        if (l == 0) return 0;
        int[] dp = new int[l];

         dp[0] =0;
         int cost =prices[0];
        for (int i = 1; i < l; i++) {
          cost = Math.min(cost,prices[i]);
          dp[i] = Math.max(dp[i-1],prices[i] - cost);
        }
        return dp[l-1];
    }


    public static void main(String[] args) {
        int[] prices = {2,4,1};
        MaxProfit_63 maxProfit63 = new MaxProfit_63();
        int res = maxProfit63.maxProfit2(prices);
        System.out.println(res);
    }

}
