package leetcode.year2022.hot100.zifuchuan;

import javax.print.DocFlavor;
import java.util.*;

import static javax.swing.UIManager.put;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 */
public class IsValid {
    /**
     * 思路：使用栈,以左括号为例，思路如下：
     * 1.空字符串本身就是一个有效的括号
     * 2.字符串长度不是偶数则不是有效的
     * 3.左括号最希望匹配右括号、如果下一个字符不是"）"，
     *  则先把下一个字符也入栈，下一个字符同样会渴望匹配与它对应的字符
     *  如果能见到、则直接将左括号出栈
     */
    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        int len = s.length();
        if(len % 2 != 0) //长度为奇数、无效
            return false;
        if (s.length() == 0) //长度为0、有效
            return true;
        char ch0 = s.charAt(0); //第一个字符符合下面的条件、无效
        if (ch0 == ')' || ch0 == ']' || ch0 == '}')
            return false;

       //判断字符是否匹配
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (!stack.isEmpty() && ch == ')'  && stack.peek() == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && ch == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && ch == '}' && stack.peek() == '{'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        if (stack.isEmpty())
            return true;
        return false;

    }
    //尝试使用Map
    public static boolean isValid2(String s) {
        int len = s.length();
        if (len == 0) return true;
        if (len % 2 != 0) return false;
        Deque<Character> stack = new LinkedList<>();
        Map<Character,Character> map = new HashMap<>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }

        }

        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(IsValid.isValid("(])"));
    }
}
