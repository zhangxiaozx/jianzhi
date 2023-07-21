package leetcode.year2022.jianzhioffer_1;

public class Test {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {1,2,1};
        System.out.println(test.singleNumber(nums));
    }
}
