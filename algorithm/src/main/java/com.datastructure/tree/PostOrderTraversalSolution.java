package com.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/12/16 16:34
 * @Description: 后续遍历  左子树 ---> 右子树 ---> 根结点
 */
public class PostOrderTraversalSolution {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.stream().forEach(integer -> System.out.println(integer));
    }

    public List<Integer> postOrderTraversal(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        return res;
    }

    private void postOrderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            res.add(root.val);
        }

    }

    public List<Integer> posOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //TODO
        return res;
    }
}
