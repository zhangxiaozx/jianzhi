package leetcode.year2022.jianzhioffer_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindRepeatNumber_03 {

    public static int findRepeatNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]))
                return nums[i];
            map.put(nums[i], i);
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            /*if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return nums[i];
            }*/

            //优化
            if (!set.add(nums[i]))
                return nums[i];

        }

        return -1;
    }



    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int res = findRepeatNumber(nums);
        int res2 = findRepeatNumber2(nums);

        System.out.println(res);
        System.out.println(res2);

    }
}
