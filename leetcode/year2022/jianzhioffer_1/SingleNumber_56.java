package leetcode.year2022.jianzhioffer_1;

import java.util.HashMap;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 */
public class SingleNumber_56 {

    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }


        for (int k: map.keySet()){
            if (map.get(k) == 0)
                return k;
        }

        return -1;

    }

    public static void main(String[] args) {
        SingleNumber_56 s = new SingleNumber_56();
        int[] nums = {3,4,4,4};
        int res = s.singleNumber(nums);
        System.out.println(res);
    }
}
