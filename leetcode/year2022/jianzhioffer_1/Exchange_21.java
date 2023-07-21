package leetcode.year2022.jianzhioffer_1;

public class Exchange_21 {

    /**
     * 我的方法
     */
    public int[] exchange(int[] nums) {
        int len = nums.length;
       int[] res = new int[nums.length];
       int l=0, r = len -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0){
                res[r--] = nums[i];
            }else {
                res[l++] = nums[i];
            }
        }

        return res;
    }

    /**
     * 题解方法：双指针
     */
    public int[] exchange2(int[] nums){
        int i = 0;
        int j = nums.length - 1;
        int tmp;
        while(i < j){
            while (nums[i] % 2 != 0 && i < j){
                i++;
            }
            while (nums[j] % 2 == 0 && i < j){
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        return nums;
    }

    public static void main(String[] args) {
        Exchange_21 exchange = new Exchange_21();
        System.out.println(exchange.exchange(new int[]{1,3,5}));
        System.out.println(exchange.exchange2(new int[]{1,3,5}));
    }
}
