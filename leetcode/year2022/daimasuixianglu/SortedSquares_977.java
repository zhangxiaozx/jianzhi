package leetcode.year2022.daimasuixianglu;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

/**
 * 977. 有序数组的平方
 * 给你一个按非递减顺序排序的整数数组nums，
 * 返回每个数字的平方组成的新数组,要求也按非递减顺序排序。
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */
public class SortedSquares_977 {


    /**
     * 双指针解法
     */
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        for (; i <= j; ) {
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if (a >= b) {
                res[k--] = a;
                i++;
            } else {
                res[k--] = b;
                j--;
            }
        }
        return res;

    }

    public static boolean compareResult(String expectOperator, float resultVal, float expectVal) {
        boolean flag = false;
        if (Objects.equals(expectOperator, "<")) {
            if (resultVal < expectVal) {
                flag = true;
            }
        } else if (Objects.equals(expectOperator, "=")) {
            if (resultVal == expectVal) {
                flag = true;
            }
        } else {
            if (resultVal > expectVal) {
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] res = SortedSquares_977.sortedSquares(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
