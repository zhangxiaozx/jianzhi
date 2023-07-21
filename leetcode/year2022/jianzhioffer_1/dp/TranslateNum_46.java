package leetcode.year2022.jianzhioffer_1.dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TranslateNum_46 {
    public int translateNum(int num){
        String numStr = String.valueOf(num);
        int len = numStr.length();
        if (len == 0 || len == 1) return len;
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<len; i++){
            String tmp = numStr.substring(i-2,i);
            if (tmp.compareTo("10") >=0 && tmp.compareTo("25")<=0)
                dp[i] = dp[i-1] + dp[i-2];
            else
                dp[i] = dp[i-1];

        }
        return dp[len];

    }

}
