package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:47
 * @Description: 判断一棵二叉树是否是平衡二叉树
 * 判断是否存在某课子树的左右查高过一
 */
public class BalanceBSTSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(8);
        root.left = treeNode;
        root.right = treeNode1;
        TreeNode treeNode2 = new TreeNode(11);
        treeNode.left = treeNode2;
        TreeNode treeNode3 = new TreeNode(13);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(2);
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        TreeNode treeNode7 = new TreeNode(5);
        TreeNode treeNode8 = new TreeNode(1);
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        BalanceBSTSolution balanceBSTSolution = new BalanceBSTSolution();
        System.out.println(balanceBSTSolution.isBalance(root));

    }

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    //Height对象来帮助记忆
    public boolean isBalance(TreeNode root, Height height) {
        //叶子节点，高度为0
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height leftHeight = new Height();
        Height rightHeight = new Height();
        //如何理解这一块
        //当左右子树都是平衡树的时候
        if (isBalance(root.left, leftHeight) && isBalance(root.right, rightHeight)) {
            //我们来看下当前树是不是平衡树,这时候，我们已经得到了左右子树的高度，只需要比较高度差
            //那么我们是如何得到左右子树高度的
            if (Math.abs(leftHeight.height - rightHeight.height) <= 1) {
                //当其是平衡数的时候，直接获取最大的加一
                height.height = 1 + Math.max(leftHeight.height, rightHeight.height);
                return true;
            }
            //如果不是，那么我们无需计算，直接返回一个false,就提前结束
            return false;
        }

        return false;
    }
    //使用迭代优化
    /*
     *因为在遍历每个结点时都要求其左右子树的深度，因此复杂度是O(n^2)的。但可以发现，为每个结点计算树的深度是重复（我觉得用多余来形容比较好）的，如左右子树的深度求得的情况下，其直接父亲树的深度就可以不必求了。

     * 采用后序遍历的方式遍历二叉树的每一个节点，在遍历到一个节点之前我们就已经遍历了它的左右子树。此时，记录每个节点为根节点的树的高度，就可以一边遍历一边判断每个节点是不是平衡的。
     * */

    class Height {
        int height;
    }
}
