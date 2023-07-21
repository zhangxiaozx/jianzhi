package leetcode.year2022.jianzhioffer_1;

public class PrintNumver_17 {

    /**
     *我初次想到的方法
     */
    public int[] printNumbers(int n) {

        if(n == 0)  return new int[]{};
        String endNum = "";
        while(n >= 1){
            endNum = endNum + "9";
            n--;
        }
        int endNumber = Integer.valueOf(endNum);
        int[] res = new int[endNumber];
        for(int i = 1; i <= endNumber; i++){
            res[i-1] = i;
        }

        return res;

    }
    /**
     * 题解：找规律
     */
    public int[] daShuPrint(int n){
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < n+1; i++) {
            res[i-1] = i;
        }
        return res;
    }


    public static void main(String[] args) {
        PrintNumver_17 print = new PrintNumver_17();
        System.out.println(print.printNumbers(1));
    }
}
