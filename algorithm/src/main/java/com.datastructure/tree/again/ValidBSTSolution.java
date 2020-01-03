package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2020/1/3 11:09
 * @Description: 校验是否是个有效的二叉树
 * 左节点不大于根节点，右节点不小于根节点
 */
public class ValidBSTSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode treeNode = new TreeNode(3);
        root.left = treeNode;
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(4);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(7);

        root.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(8);
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        ValidBSTSolution validBSTSolution = new ValidBSTSolution();
        System.out.println(validBSTSolution.isValidBSTByTraversal(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lowerValue, Integer upperValue) {
        if (root == null) {
            return true;
        }
        if (lowerValue != null && lowerValue > root.val) {
            return false;
        }
        if (upperValue != null && upperValue < root.val) {
            return false;
        }
        if (isValidBST(root.left, null, root.val) && isValidBST(root.right, root.val, null)) {
            return true;
        }
        return false;
    }

    //使用迭代优化递归
    public boolean isValidBSTByTraversal(TreeNode root) {
        Integer currentMin = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode node = stack.pop();
            if (node.val < currentMin) {
                return false;
            }
            currentMin = node.val;
            currentNode = node.right;
        }
        return true;
    }
}
