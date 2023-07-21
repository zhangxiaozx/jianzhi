package leetcode.year2022.jianzhioffer_1;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BuildTree07 {

    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>(); //标记中序遍历

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);

    }

    TreeNode recur(int root, int left, int right) {

        if (left > right) return null; //递归终止
        TreeNode node = new TreeNode(preorder[root]); //建立根节点
        int i = map.get(preorder[root]); //获取在中序遍历中根结点所在索引，以方便获取左子树的数量
        node.left = recur(root + 1, left, i - 1);  //开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); //开启右子树递归
        return node; //回溯返回根节点
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
