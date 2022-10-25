package leetcode.year2022.hot100.shuzu;

/*date:20220515
题目：
   给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。
一、示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：
------------------------------------------------
二、思路：
  1.连续：索引必须是连续的
  2.最大和：最终的结果在数组所有可能的组合中是最大的
  3.既然是最大：则需要找对应的索引数字可以给结果做贡献的值。
  4.
  (1)从头到尾，将数字依次相加，如果当前数字+已得到的结果 < 已得到的结果，则舍弃当前数字，从当前数字所在索引位置的下一个值
  开始重新加和。
  (2)设置一个最大和的变量值，将当前和与最大和进行比较、最大和要取最大的那个值。
  (3)极端情况：数组大小为1，则直接返回数组中的位置为0的值。
*/
public class MaxSubArray {

    /*贪心法*/
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = sum;
        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 1; i < nums.length; i++) {

            sum = Math.max(sum + nums[i], nums[i]);

            maxSum = maxSum > sum ? maxSum : sum;

        }
        return maxSum;
    }

    /*动态规划法:
    * 若前一个元素大于0，则将其加到当前元素上*/
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > 0){
                nums[i] = nums[i - 1] + nums[i];
            }
            max=  max > nums[i] ? max : nums[i];
        }
        return  max;
    }

        public static void main(String[] args) {

        MaxSubArray maxSubArray = new MaxSubArray();
        int[] test = new int[]{5,4,-1,7,8};
        int res = maxSubArray.maxSubArray(test);
        System.out.println("贪心法：" + res);

        res =  maxSubArray.maxSubArray2(test);
            System.out.println("动态规划法：" +  res);
    }
}
