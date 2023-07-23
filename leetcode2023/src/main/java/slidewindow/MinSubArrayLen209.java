package slidewindow;

/**
 *https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 209：长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen209 {
    /**
     * 维护一个可以滑动的窗口，并使用sum记录窗口内的和
     */
    public static  int minSubArrayLen(int target, int[] nums){
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        //窗口的起始位置是left，终止位置是right。计算[left,right]中数值的和
        for(int rigth = 0; rigth < nums.length; rigth++){

            sum = sum + nums[rigth]; //right位置更新后，更新sum值

            //窗口内的和大于等于目标值，则循环更新窗口左边界的位置(题目：满足其和 ≥ target 的长度最小的 连续子数组)
            //注意：条件是>=，不是=

            while (sum >= target){
                sum = sum - nums[left];
                int subLen = rigth - left + 1; //记录符合条件的子序列的长度
                minLen = minLen > subLen ? subLen : minLen; //更新最小连续子数组的长度
                left++; //更新left的位置，直到[left,right]窗口内的和<target

            }

        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 11;
        System.out.println( minSubArrayLen(target, nums) );
    }
}
