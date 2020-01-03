package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2020/1/3 11:09
 * @Description: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumSolution {

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
        PathSumSolution pathSumSolution = new PathSumSolution();
        List<List<Integer>> res = pathSumSolution.pathSum(root, 22);
        for (List<Integer> integerList : res) {
            for (Integer i : integerList) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Integer> track = new Stack<>();
        track.push(root.val);
        trackBack(root, sum, root.val, track, res);
        return res;
    }

    public void trackBack(TreeNode currentNode, Integer targetSum, Integer currentSum, Stack<Integer> track, List<List<Integer>> res) {
        if (currentNode.left == null && currentNode.right == null) {
            if (currentSum == targetSum) {
                res.add(new ArrayList<>(track));
            }
            return;
        }
        if (currentNode.left != null) {
            track.push(currentNode.left.val);
            trackBack(currentNode.left, targetSum, currentSum + currentNode.left.val, track, res);
            track.pop();
        }
        if (currentNode.right != null) {
            track.push(currentNode.right.val);
            trackBack(currentNode.right, targetSum, currentSum + currentNode.right.val, track, res);
            track.pop();
        }
    }
}
