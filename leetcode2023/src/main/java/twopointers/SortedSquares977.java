package twopointers;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 * 有序数组的平方
 */
public class SortedSquares977 {

    /**
     * 双指针法：数组是有序的，数组的最大值在数组两端，不是最左边就是最右边（不可能在中间）
     * 因为可以使用双指针法，left指向数组的起始位置、right指向数组的终止位置
     * 定义一个新数组res、长度与nums相同，用于存放结果集
     * 如果nums[left] * nums[left] <= nums[right] * nums[right],则res[k--] = nums[right] * nums[right]
     * 反之：res[k--] = nums[left] * nums[left]
     */
    public static int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length];
        int len = nums.length;
        int left = 0,right = nums.length - 1;
        int k = len -1 ;

        while(left <= right){
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];
            if(leftVal <= rightVal)
            {
                res[k--] = rightVal;
                right --;
            }
            else {
                res[k--] = leftVal;
                left ++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
       int[] res = SortedSquares977.sortedSquares(new int[]{-4,-3,-2,0,1,3,4,5,6});
        System.out.println(Arrays.toString(res));


    }
}
