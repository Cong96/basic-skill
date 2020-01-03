package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:49
 * @Description:
 */
public class LevelTraversalSolution {

    public static void main(String[] args) {

    }

    public List<Integer> levelTraversal(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        if (treeNode == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return res;
    }
}
