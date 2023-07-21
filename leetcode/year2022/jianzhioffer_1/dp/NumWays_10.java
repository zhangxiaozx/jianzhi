package leetcode.year2022.jianzhioffer_1.dp;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class NumWays_10 {
    public static int numWays(int n){

        /**
         * 最后若剩下一个台阶、则有f(n-1)种跳法、若剩下2个台阶、则有f（n-2）种跳法
         * 所以有f(n) = f(n-1) + f(n-2)种跳法
         * 定义一维dp数组：dp[i]代表跳上i级台阶的跳法
         * dp[0] = 1,dp[1]=1
         * dp[n] = dp[n-1] + dp[n-2]
         */

        if (n == 0 || n == 1)
            return 1;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int sum = 0;

        for (int i = 2; i < n+1; i++) {
            //取模需要在计算和的时候取、因为和可能会造成数值过大而溢出
            dp[i] = (dp[i-1] + dp[i-2])% 1000000007;

        }
        return sum;
    }

    public static void main(String[] args) {
        NumWays_10 numWays = new NumWays_10();
        System.out.println(numWays(7));
    }
}
