package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2020/1/3 11:10
 * @Description:
 */
public class InOrderTraversalSolution {

    public static void main(String[] args) {

    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (currentNode != null || !stack.isEmpty()) {
            //如果某个节点的右子树空了
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            //那么就拿上一层的节点来试试看
            TreeNode node = stack.pop();
            res.add(node.val);
            currentNode = currentNode.right;
        }
        return res;
    }
}

