package leetcode.year2022.hot100.shuzu;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 26;
        int[] res = TwoSum.twoSum(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }else {
                hashMap.put(nums[i], j++);
            }
        }
        return null;
    }

}

