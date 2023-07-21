package leetcode.year2022.jianzhioffer_1.SlideWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindow_59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        //如果数组长度<给定的滑动窗口长度、则返回空
        if(len < k) return new int[]{};
        int l = 0;  //左边界
        int r = l+k-1; //有边界
        int[] res = new int[len - k +1];

        List<Integer> list = new ArrayList<>(); //保存每一个窗口的最大值
        while( r < len){  //循环终止条件：右边界 < 数组长度
            int curMax = nums[l]; //当前窗口的最大值设定为当前的左边界的值
            int i = l;
            int m = i;
            for(; i <= r; i++ ){
                curMax = Math.max(curMax, nums[i]);
            }
            res[m] = curMax;
            l= l+1;
            r = r+1;
        }

        return res;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;

        if (len == 0 || k ==0 || len < k) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[len - k +1];
        for (int i=0;i<k;i++){
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        //形成窗口之后
        for (int j = k; j < len; j++) {
            if (nums[j-k] == deque.peekFirst())
                deque.removeFirst();
           while(!deque.isEmpty() && deque.peekLast() < nums[j]){
               deque.removeLast();
           }
           deque.addLast(nums[j]);
           res[j-k+1] = deque.peekFirst();
        }

return res;

    }

}
