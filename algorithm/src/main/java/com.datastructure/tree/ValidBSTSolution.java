package com.datastructure.tree;

import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/12/16 17:33
 * @Description:给定一个二叉树，判断其是否是一个有效的二叉搜索树。 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 在多数有关于树的问题中，我们都可以尝试使用递归来解决问题
 */
public class ValidBSTSolution {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lowerValue, Integer upperValue) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (lowerValue != null && lowerValue >= val) {
            return false;
        }
        if (upperValue != null && upperValue <= val) {
            return false;
        }
        //如果当前节点通过了校验，那么就校验其左右节点
        if (!isValidBST(root.left, lowerValue, val)) {
            return false;
        }
        if (!isValidBST(root.right, val, upperValue)) {
            return false;
        }
        return true;
    }

    //我们可以使用迭代来优化递归
    public boolean isValidBSTIteration(TreeNode treeNode) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<Integer> lowerStack = new Stack<>();
        Stack<Integer> upperStack = new Stack<>();
        //TODO
        return false;
    }

    public boolean isValiBSTByInorder(TreeNode treeNode) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        TreeNode cur = treeNode;
        while (cur != null || !treeNodeStack.isEmpty()) {
            while (cur != null) {
                treeNodeStack.push(cur);
                cur = cur.left;
            }
            int val = cur.val;
            if (val <= inorder) return false;
            inorder = val;
            cur = cur.right;


        }
        return false;
    }
}
