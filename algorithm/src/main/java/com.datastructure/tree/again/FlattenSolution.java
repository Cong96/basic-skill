package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:48
 * @Description:
 */
public class FlattenSolution {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {

                TreeNode pre = root.left;
                //找到左子树中最右下方的节点
                while (pre != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
