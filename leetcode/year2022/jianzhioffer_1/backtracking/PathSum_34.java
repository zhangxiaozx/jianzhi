package leetcode.year2022.jianzhioffer_1.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 */
public class PathSum_34 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target){
        if (root == null) return new ArrayList<>();
        recur(root, target);
        return res;

    }

    public void recur(TreeNode root, int target){
        if (root == null) return;
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<>(path));
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();


    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    


}








