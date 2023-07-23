package twopointers;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/remove-element/
 */
public class RemoveElement27 {
    /**
     *双指针法：快指针指向要处理的元素，慢指针指向新数组
     * 1.如果快指针指向的值 ！= val，则快指针+1，慢指针+1（扩大新数组的范围），且快指针的值=慢指针的值
     * 2.如果快指针指向的值 == val，则该值不应该被包含在新数组中：此时快指针继续向前走、慢指针不动
     */

    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        //看一下修改后数组的值
        System.out.println(Arrays.toString(nums));
        return nums.length;
    }



    public static void main(String[] args) {
        //数组一旦创建，就不能再改变它的大小
      RemoveElement27 removeElement27 = new RemoveElement27();
      int len = removeElement27.removeElement(new int[]{1,2,2,3,3,4,5,6} , 2);
        System.out.println(len);
    }
}
