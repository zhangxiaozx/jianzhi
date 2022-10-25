package leetcode.year2022.daimasuixianglu.slidewindow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组
 */
public class MinSubArrayLen_209 {
    //滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        //获取数组长度
        int len = nums.length;
        int res = Integer.MAX_VALUE; //结果值初始化为最大值
        int i = 0;
        int sum = 0;
        for (int j = 0; j < len; j++) {
            sum = sum + nums[j];
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum = sum - nums[i];
                i++;
            }

        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = MinSubArrayLen_209.minSubArrayLen(8, nums);
        System.out.println(res);


    }

}
