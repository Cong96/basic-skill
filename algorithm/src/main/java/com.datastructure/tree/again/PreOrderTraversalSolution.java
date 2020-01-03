package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2020/1/3 13:46
 * @Description:
 */
public class PreOrderTraversalSolution {
    public static void main(String[] args) {

    }

    public List<Integer> perOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                res.add(currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode node = stack.pop();
            currentNode = currentNode.right;
        }

        return res;
    }
}
