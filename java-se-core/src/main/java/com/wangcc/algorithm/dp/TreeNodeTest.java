package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/28 09:39
 * @Description:
 */
public class TreeNodeTest {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        preOrder(reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8},
                new int[]{4, 7, 2, 1, 5, 3, 8, 6}));
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        if (treeNode.left != null) {
            preOrder(treeNode.left);
        }
        if (treeNode.right != null) {
            preOrder(treeNode.right);
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    public static int treeDeepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeDeepth(root.left), treeDeepth(root.right)) + 1;
    }

    public static boolean isBaclance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = treeDeepth(root.left);
        int rightDepth = treeDeepth(root.right);
        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return isBaclance(root.left) && isBaclance(root.right);
        } else {
            return false;
        }
    }
}
