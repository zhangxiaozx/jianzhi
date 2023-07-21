package leetcode.year2022.hot100.shuzu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列：https://leetcode.cn/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute_46 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums){
        if (nums.length == 0) return new ArrayList<>();
        used = new boolean[nums.length];
        dfs(nums);
        return res;


    }

    public void dfs(int[] nums){
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    //--------------

    public List<List<Integer>> permute2(int[] nums){

        if (nums.length == 0) return new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backT(nums,used,path,res);
        return res;

    }

    public void backT(int[] nums,boolean[] used,List<Integer> path,List<List<Integer>> res){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length ; i++) {
            if (used[i] == true) continue;
            used[i] = true;
            path.add(nums[i]);
            backT(nums,used,path,res);
            used[i] = false;
            path.remove(nums.length -1);

        }


    }



}
