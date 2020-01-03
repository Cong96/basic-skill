package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

import java.util.List;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:48
 * @Description: 给定一个二叉树，原地将它展开为链表。
 */
public class BuildTreeSolution {

    public static void main(String[] args) {
        int[] postorder = new int[]{3, 4, 2, 6, 5, 1};
        int[] inorder = new int[]{3, 2, 4, 1, 6, 5};
        BuildTreeSolution buildTreeSolution = new BuildTreeSolution();
        TreeNode root = buildTreeSolution.buildTree(inorder, postorder);
        PostOrderSolution postOrderSolution = new PostOrderSolution();
        List<Integer> res = postOrderSolution.posOrderTraversalIteration(root);
        for (Integer i : res) {
            System.out.println(i);
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return reConstructBinaryTreeByOrderAndPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode reConstructBinaryTreeByOrderAndPost(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        //结束条件
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode currentRoot = new TreeNode(postorder[postEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (currentRoot.val == inorder[i]) {
                currentRoot.left = reConstructBinaryTreeByOrderAndPost(inorder, inStart, i - 1, postorder, postStart, postStart + i - inStart - 1);
                currentRoot.right = reConstructBinaryTreeByOrderAndPost(inorder, i + 1, inEnd, postorder, postStart + i - inStart, postEnd - 1);
                break;
            }
        }

        return currentRoot;
    }

    public TreeNode reConstructBinaryTreeByOrderAndPre(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd) {
        TreeNode currentRoot = new TreeNode(preOrder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (currentRoot.val == inOrder[i]) {
                currentRoot.left = reConstructBinaryTreeByOrderAndPre(inOrder, inStart, i - 1, preOrder, preStart + 1, preStart + 1 + i - inStart - 1);
                currentRoot.right = reConstructBinaryTreeByOrderAndPre(inOrder, i + 1, inEnd, preOrder, preStart + i - inStart + 1, preEnd);
                break;
            }
        }
        return currentRoot;
    }
}
