package com.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/12/16 16:33
 * @Description: 前序遍历: 根结点 ---> 左子树 ---> 右子树
 */
public class PreOrderTraversalSolution {


    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderTraversal(root, res);
        return res;
    }

    private void preOrderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public List<Integer> preOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //先遍历左子树
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            //当前节点的左子树遍历完了，开始右子树
            TreeNode node = stack.pop();
            cur = node.right;
        }
        return null;
    }
}
