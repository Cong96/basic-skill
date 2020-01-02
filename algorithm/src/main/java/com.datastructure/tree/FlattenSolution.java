package com.datastructure.tree;

/**
 * @Author: BryantCong
 * @Date: 2019/12/17 11:41
 * @Description:给定一个二叉树，原地将它展开为链表。
 */
public class FlattenSolution {
    public void flatten(TreeNode root) {
        //TODO 其中是如何思考得来的？这个是关键

        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                //找到左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将右子树接到左子树最右边的节点的右子树
                pre.right = root.right;
                //将左子树根节点放置到右子树根节点处
                root.right = root.left;
                root.left = null;
                //下一个节点
                root = root.right;
            }
        }

//        while (root != null) {
//            //左子树为 null，直接考虑下一个节点
//            if (root.left == null) {
//                root = root.right;
//            } else {
//                // 找左子树最右边的节点
//                TreeNode pre = root.left;
//                while (pre.right != null) {
//                    pre = pre.right;
//                }
//                //将原来的右子树接到左子树的最右边节点
//                pre.right = root.right;
//                // 将左子树插入到右子树的地方
//                root.right = root.left;
//                root.left = null;
//                // 考虑下一个节点
//                root = root.right;
//            }
//        }

    }

}
