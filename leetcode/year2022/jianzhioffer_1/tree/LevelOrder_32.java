package leetcode.year2022.jianzhioffer_1.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        int len = 0;
        int flag = 0;
        while(deque != null){
            len = deque.size();
            List<Integer> list = new ArrayList<>();
            TreeNode[] out = new TreeNode[len];
            for(int i =0;i<len;i++){
                out[i] = deque.poll();
                list.add(out[i].val);
            }

            int k = 0;
            if(flag == 0){
                while(k < len){
                    if(out[k].left != null)
                        deque.add(out[k].left);

                    if(out[k].right != null)
                        deque.add(out[k].right);
                    k++;
                }
                flag = 1;
            }

            int m = len -1;
            if(flag == 1){
                while(m > 0){
                    if(out[m].right != null)
                        deque.add(out[k].right);

                    if(out[k].left != null)
                        deque.add(out[k].left);
                    m--;
                }
                flag = 0;
            }

            lists.add(list);

        }

        return lists;


    }



}
