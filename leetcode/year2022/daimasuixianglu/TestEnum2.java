package leetcode.year2022.daimasuixianglu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;


public class TestEnum2 {

    public static void main(String[] args) {

        Weekday day = Weekday.SUN;

        if (day.dayValue == 6 || day.dayValue == 0) {

            System.out.println("Today is " + day + ". Work at home!");

        } else {

            System.out.println("Today is " + day + ". Work at office!");

        }

        String expectVal = "0.05";
        BigDecimal expectDecimal = new BigDecimal(expectVal);
        System.out.println(expectDecimal);
        int a = 10;
        int b = 10;
        BigDecimal startVal = new BigDecimal(a);
        BigDecimal endVal = new BigDecimal(b);


        System.out.println(startVal + "%");

        BigDecimal c = new BigDecimal("123");
        System.out.println(c.setScale(2, RoundingMode.DOWN));

        System.out.println(isGreater(endVal, startVal));
        System.out.println(endVal.compareTo(startVal));

        System.out.println("两个值是否相等：" + isEquals(startVal, endVal));

        System.out.println("两个值是否相等objects：" + isEqualsObject(startVal, endVal));


        String expectValStr = "0.05%";
        int waveFlag;
        if (expectValStr.contains("%")) {
            waveFlag = 1;

            expectValStr = expectValStr.replace("%", "");
            // expectVal = new BigDecimal(expectValStr);
        } else {
            waveFlag = 0;
            // expectVal = new BigDecimal(expectValStr);
        }
        BigDecimal expectVal2 = new BigDecimal(expectValStr);
        System.out.println("expectVal2 = " + expectVal2 + "   waveFlag:" + waveFlag);


    }

    private static boolean isGreater(BigDecimal result, BigDecimal expect) {
        if (result.compareTo(expect) == 1)
            return true;
        return false;
    }

    public static boolean isEquals(BigDecimal val, BigDecimal valCompare) {
        if (val.compareTo(valCompare) == 0)
            return true;
        return false;
    }

    public static boolean isEqualsObject(Object val, Object valCompare) {
        if (Objects.equals(val, valCompare))
            return true;
        return false;
    }

}

enum Weekday {

    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;

    private final String chinese;

    private Weekday(int dayValue, String chinese) {

        this.dayValue = dayValue;

        this.chinese = chinese;

    }

    @Override

    public String toString() {

        return this.chinese;

    }

}