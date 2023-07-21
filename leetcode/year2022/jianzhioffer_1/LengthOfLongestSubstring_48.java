package leetcode.year2022.jianzhioffer_1;

import java.util.HashMap;

public class LengthOfLongestSubstring_48 {

    /**
     * 滑动窗口：哈希表+双指针
     */
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        if (len == 0) return 1;

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = -1; //左指针j：记录不重复子串的开始位置

        for (int i = 0; i < len; i++) {

            char tmp = s.charAt(i);

            //更新左指针的开始位置:取j和已存在的字符位置之间的最大值（以abbcbaaaa为例子，如果不取最大值，可能取到当前j位置之前的值，而在这之前的位置已经被计算过了，要保证j到当前位置之间无重复字符）
            if (map.containsKey(tmp)) {
                j = Math.max(j,map.get(tmp));
            }
            map.put(tmp, i);
            max = Math.max(max, i - j);

        }
        return max;

    }


    public static void main(String[] args) {
        String s = "abbcbaaaa";
        LengthOfLongestSubstring_48 lengthOfLongestSubstring = new LengthOfLongestSubstring_48();
        int res = lengthOfLongestSubstring.lengthOfLongestSubstring(s);

        System.out.println(res);

    }
}
