package leetcode.year2022.hot100.zifuchuan;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class LengthOfLongestSubstring {
    /**
     *滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        //设置左指针，初始位置指向索引0的字符
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                //如果map中包含该字符串，则移动left：将字符已经重复出现的位置与当前的left比较大小、哪个大、就将哪个赋予left
                //这样就可以保证i和left之间的数据都是不重复的
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            map.put(s.charAt(i), i);  //然后无论字符有没有出现过、都将字符put进map、若是出现过的、则会覆盖原来的value
            max = Math.max(max, i - left + 1);
        }

       return max;
    }

    public static void main(String[] args) {
       int res = LengthOfLongestSubstring.lengthOfLongestSubstring("puyrrpwe");
        System.out.println(res);

    }
}
