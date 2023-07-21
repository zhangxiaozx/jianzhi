package leetcode.year2022.hot100.zifuchuan;

import java.util.ArrayList;
import java.util.List;

public class Partition_131 {


        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if(s == null || s.length() == 0) return res;
            dfs(s, 0);
            return res;

        }

        public void dfs(String s,  int index){

            if(index >= s.length()) {
                res.add( new ArrayList<>(path));
                return;
            }

            for(int i= index; i< s.length(); i++){
                String subStr = s.substring(index, i +1);
                if( isHuiWen(subStr) ){
                    path.add(subStr);
                }else {
                    continue;
                }
                dfs(s, i+1);
                path.remove(path.size() -1 );
                System.out.println(index);

            }

        }



        public boolean isHuiWen(String s){

            for(int i= 0, j = s.length() - 1; i < j; i ++, j--){
                if(s.charAt(i) != s.charAt(j))
                    return false;
            }

            return true;

        }

    public static void main(String[] args) {
        String s = "aab";
        Partition_131 partition = new Partition_131();
        List<List<String>> res = partition.partition(s);
        System.out.println(res.toString());

    }

}
