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
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode proot;//标记栈顶元素前一个被访问的元素
//        boolean flag;//root的左孩子未被访问；
//        if (root != null) {
//            do {
//                while (root != null) {//将root所有左孩子全部入栈
//                    stack.push(root);
//                    root = root.left;
//                }
//
//                //执行到此处，栈顶元素没有左孩子或者左子树已经被访问过；
//                proot = null;//标记栈顶元素前一个被访问的元素，或者此时为最左下边，该元素前一个被访问的元素肯定为空。
//                flag = true;//root的左孩子已经被访问；或者root为null
//
//                while (!stack.isEmpty() && flag) {
//                    root = stack.peek();       //取到栈顶元素，但是不出栈；
//                    if (root.right == proot) {
//                        root = stack.pop();
//                        res.add(root.val);
//                        proot = root;
//                    } else {
//                        root = root.right;
//                        flag = false;//root左边孩子未被访问；
//                    }
//                }
//            } while (!stack.isEmpty());
//        }
//        return res;
        return null;
    }
}
