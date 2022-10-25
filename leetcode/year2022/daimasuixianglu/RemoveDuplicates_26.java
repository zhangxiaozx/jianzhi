package leetcode.year2022.daimasuixianglu;

/**
 * 给你一个升序排列的数组nums ，
 * 请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。元素的相对顺序应该保持一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。
 * 更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates_26 {
    public static int removeduplicates(int[] nums){
        int slow = 0;
        int fast = 1;
        int len = nums.length;
        if (len == 1) return 1;
        for (; fast < len ; fast++) {
            if (nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int res  = RemoveDuplicates_26.removeduplicates(nums);
        System.out.println(res);
    }
}
