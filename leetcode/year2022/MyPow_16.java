package leetcode.year2022;

public class MyPow_16 {

    public double myPow(double x, int n) {
        if(n == 0) return 1;


        double res = 1;
        long b = n;
        if (b < 0){
            b = -b;
            x = 1/x;
        }

        while(b!=0){
            if ((b&1) ==1) {
                res = res * x;
            }
            x = x * x;
            b>>=1;
        }
        return res;

    }

    public static void main(String[] args) {
        MyPow_16 myPow = new MyPow_16();
        System.out.println(myPow.myPow(1.00000 ,-2147483648));
        System.out.println(11 & 1);
    }
}
