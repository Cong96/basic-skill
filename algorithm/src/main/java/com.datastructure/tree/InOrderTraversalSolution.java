package com.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/12/16 15:23
 * @Description: 中序遍历：左子树---> 根结点 ---> 右子树
 * <p>
 * <p>
 * 二叉树的遍历都可以借助栈结构使用DFS算法完成。  深度优先遍历
 */

enum NodeColor {
    RED,
    GRAY;
}

class ColoredTreeNode {
    TreeNode node;
    NodeColor color;

    public ColoredTreeNode(TreeNode node, NodeColor color) {
        this.node = node;
        this.color = color;
    }
}

public class InOrderTraversalSolution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //这里不可能为空，所以没关系
            TreeNode node = stack.pop();
            res.add(node.val);
            cur = node.right;
        }
        return res;
    }

    public List<Integer> inorderTravelsalColor(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColoredTreeNode> stack = new Stack<>();
        stack.push(new ColoredTreeNode(root, NodeColor.RED));

        while (!stack.empty()) {
            ColoredTreeNode cn = stack.pop();

            if (cn.color ==NodeColor.RED){
                if (cn.node.right != null) {
                    stack.push(new ColoredTreeNode(cn.node.right, NodeColor.RED));
                }
                stack.push(new ColoredTreeNode(cn.node, NodeColor.GRAY));
                if (cn.node.left != null) {
                    stack.push(new ColoredTreeNode(cn.node.left, NodeColor.RED));
                }
            } else{
                res.add(cn.node.val);
            }
        }

        return res;
    }

    /*
     *   递归法，简单易懂，但是提交的时候发现内存消耗过大
     *   使用到了递归，这个也是自然的。
     *
     * */
    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorderTraversal(root.left, res);
            res.add(root.val);
            inorderTraversal(root.right, res);
        }
    }
}
