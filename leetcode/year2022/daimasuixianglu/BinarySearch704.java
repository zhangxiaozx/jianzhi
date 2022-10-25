package leetcode.year2022.daimasuixianglu;

import java.util.Objects;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 */
public class BinarySearch704 {

    /**
     * 二分查找/折半查找
     *
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        if (len == 0) return -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        BinarySearch704 bs = new BinarySearch704();
        int res = bs.search(nums, target);
        System.out.println(res);

        Float b = Float.valueOf(0);

        int c = 0;
        System.out.println(b==c);
        BinarySearch704 binarySearch704 = new BinarySearch704();
    }


}
