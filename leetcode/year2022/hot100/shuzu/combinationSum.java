package leetcode.year2022.hot100.shuzu;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null) return res;
        dfs(candidates, target, 0, 0);
        return res;

    }

    public void dfs(int[] candidates, int target, int sum, int index){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }else if(sum > target && index < candidates.length ){
            index = index + 1;
            return;
        }else if(sum > target){
            return;
        }

        for(int i=index; i< candidates.length; i++){

                path.add(candidates[i]);
                sum = sum + candidates[i];
                dfs(candidates, target, sum, i);
                sum = sum - candidates[i];
                path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        combinationSum com = new combinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = com.combinationSum(candidates, target);
        for (List<Integer> path : res) {
            System.out.println(path);

        }
    }
}
