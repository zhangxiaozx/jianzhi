package leetcode.year2022;

public class HammingWeight_15 {

    public int hammingWeight(int n) {


        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        int res=0;
        for(int i=0;i<s.length();i++){
            if(ch[i] =='1')
                res++;
        }

        return  res;

    }
}
