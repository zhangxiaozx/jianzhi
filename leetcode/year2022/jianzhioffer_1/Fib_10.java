package leetcode.year2022.jianzhioffer_1;
/*斐波那契数列*/
public class Fib_10 {

    public int fib(int n) {
        if (n==0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n-1) + fib(n-2);

    }

    public static void main(String[] args) {
        Fib_10 fib = new Fib_10();
        System.out.println(fib.fib(10));
    }
}
