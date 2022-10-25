package leetcode.year2022.daimasuixianglu.slidewindow;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class MinWindow_76 {
    public static String minwindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS < lenT) return "";

        int left = 0;
        int res = Integer.MAX_VALUE;
        String str = ""; //字符串变量
        char[] sChar = s.toCharArray();
        int subLen = 0;
        String resStr = "";


        for (int j = 0; j < lenS; j++) {
            str = str + sChar[j];
            int strLen = str.length();

            while (strLen >= lenT) {
                if (str.contains(t)) {
                    subLen = j - left + 1;
                    if (res < subLen) {
                        resStr = str;
                    }
                }

                res = Math.min(res, subLen);

                left++;
                strLen--;

            }

        }
        return resStr;

    }

    public static void main(String[] args) {
        String s=  "ADOBECODEBANC";
        String t = "ABC";

        String res = MinWindow_76.minwindow(s, t);
        System.out.println(res);
        System.out.println("test");


    }

}
