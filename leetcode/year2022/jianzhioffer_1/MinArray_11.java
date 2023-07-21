package leetcode.year2022.jianzhioffer_1;

/**
 * 寻找旋转数组的最小元素：经过变化的二分查找法
 */
public class MinArray_11 {

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (right == 0) return numbers[right];
        int mid = 0;
        while (left < right){
            mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right] ){
                right = mid;
            }else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else{
                right--;
            }

        }

        return numbers[mid];

    }

    public static void main(String[] args) {
        MinArray_11 minArray_11 = new MinArray_11();
        int[] numbers = {1,3};
        System.out.println(minArray_11.minArray(numbers));
    }
}
