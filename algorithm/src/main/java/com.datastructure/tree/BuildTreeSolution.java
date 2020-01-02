package com.datastructure.tree;

/**
 * @Author: BryantCong
 * @Date: 2019/12/16 17:34
 * @Description:
 */
public class BuildTreeSolution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return reConstructBinaryTreeByOrderAndPost(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return reConstructBinaryTreeByOrderAndPre(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode reConstructBinaryTreeByOrderAndPre(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                root.left = reConstructBinaryTreeByOrderAndPre(pre, preStart + 1, i - inStart + preStart, in, inStart, i - 1);
                root.left = reConstructBinaryTreeByOrderAndPre(pre, i - inStart + preStart + 1, inEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    public static TreeNode reConstructBinaryTreeByOrderAndPost(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd) {

        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (post[postEnd] == in[i]) {
                root.left = reConstructBinaryTreeByOrderAndPost(post, postStart, postStart + i - inStart, in, inStart, i - 1);
                root.right = reConstructBinaryTreeByOrderAndPost(post, postStart + i - inStart + 1, postEnd - 1, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }
}
