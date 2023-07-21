package leetcode.year2022.jianzhioffer_1.zifuchuan;

import java.util.ArrayList;
import java.util.List;

class Permutation_38 {
    StringBuilder path = new StringBuilder();
    List<String> res;
    boolean[] used;

    public String[] permutation(String s) {
        int n = s.length();
        if(n == 0) return new String[]{};

        res = new ArrayList<String>();
        used = new boolean[n];

        backTrack(s);

        String[] resArr = new String[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i] = res.get(i);
        }

        return resArr;



    }

    public void backTrack(String s){
        if(path.length() == s.length()){
            res.add(path.toString());
            return;
        }
        for(int i=0; i < s.length(); i++){
            if(used[i] == true) continue;
            path = path.append(s.charAt(i));
            used[i]=true;
            backTrack(s);
            path.deleteCharAt(path.length() -1);

        }

    }


    public static void main(String[] args) {
        char a ='b';
        char b='b';
        System.out.println(a==b);
    }
}