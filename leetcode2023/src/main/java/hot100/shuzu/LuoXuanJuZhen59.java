package hot100.shuzu;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix。
 */
public class LuoXuanJuZhen59 {
    /**
     * 生成一个空矩阵，然后模拟整个向内环绕的填入过程
     */
    public static  int[][] generateMatrix(int n){
        //定义当前上、下、左、右边界
        int left = 0, right = n-1, top = 0, down = n-1;
        int num = 1; //初始值num为1
        int nn = n * n; //迭代终止值
        int[][] juzhen = new int[n][n];

        //当num<nn时，循环将数据填入矩阵中.
        // 循环顺序：左 ➡ 右， 上 ➡ 下,️  右 ➡ 左,️ 下 ➡ 上，然后再循环、直到不满足循环条件为止
        //每次填入num后、执行num+1
        while(num <= nn){

            for(int i = left; i<= right; i++){ //从左至右填充数字
                juzhen[top][i] = num++; //填入num
            }
            //更新上边界:相当于上边界向内缩1
            top ++;

            for (int i = top; i <= down; i++){ //从上至下填充
                juzhen[i][right] = num++;
            }

            //更新右边界
            right --;

            for (int i = right; i >= left ; i--) {  //从右至左填充
                juzhen[down][i] = num++;

            }
            //更新下边界
            down --;

            for (int i = down; i >= top; i--){ //从下至上填充
                juzhen[i][left] = num++;

            }
            //更新左边界
            left++;


        }
        return  juzhen;

    }

    public static void main(String[] args) {
        int n = 3;
        int[][] res = generateMatrix(n);
        for (int[] k : res) {
            System.out.println(Arrays.toString(k));

        }

    }
}
