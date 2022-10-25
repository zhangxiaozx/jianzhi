package leetcode.year2022.jianzhioffer_1;

public class replaceSpace_05 {

    private static String replaceSpace(String s) {

        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char ch : chars) {

            if (ch == ' ')
                res.append("%20");
            else res.append(ch);

        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
