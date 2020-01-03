package com.datastructure.tree.again;

import com.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2020/1/3 15:30
 * @Description:
 */
public class PostOrderSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode treeNode = new TreeNode(3);
        root.left = treeNode;
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(4);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(7);

        root.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(8);
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        PostOrderSolution postOrderSolution = new PostOrderSolution();
        List<Integer> res = postOrderSolution.posOrderTraversalIteration(root);
        for (Integer i : res) {
            System.out.println(i);
        }
    }

    public List<Integer> posOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //我们需要保存上一个遍历的节点
        TreeNode preNode;   //对于每一个子树的最左下方的节点来说，在当前遍历中，他的上一个节点都是null
        boolean flag; //标记当前的左子树是否遍历过了
        if (root == null) {
            return res;
        }
        TreeNode currentNode = root;
        //还是没有完全理解
        do {
            //先将所有的左孩子入栈
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            preNode = null;//对于每个子树的最左下方的节点来说，在当前遍历中，他的上一个节点都是null  对于没有右子树的节点来说，他的上一次遍历的节点也是null
            flag = true;
            while (!stack.isEmpty() && flag) {
                TreeNode node = stack.peek();//不出栈
                if (node.right == preNode) {  //如果是没有右子树的情况，或者右孩子也遍历完了
                    stack.pop();
                    res.add(node.val);
                    preNode = node;
                } else {
                    currentNode = node.right;  //有些节点是没有右节点的，再次进入下一次循环的时候，
                    flag = false;//当前节点已经改了
                }

            }
        } while (!stack.isEmpty());

//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode proot;//标记栈顶元素前一个被访问的元素
//        boolean flag;//root的左孩子未被访问；
//        if (root != null) {
//            do {
//                while (root != null) {//将root所有左孩子全部入栈
//                    stack.push(root);
//                    root = root.left;
//                }
//
//                //执行到此处，栈顶元素没有左孩子或者左子树已经被访问过:
//                proot = null;//标记栈顶元素前一个被访问的元素，或者此时为最左下边，该元素前一个被访问的元素肯定为空。
//                flag = true;//root的左孩子已经被访问；或者root为null
//
//                while (!stack.isEmpty() && flag) {
//                    root = stack.peek();       //取到栈顶元素，但是不出栈；
//                    if (root.right == proot) {  //查看前面是不是右节点，如果是，才证明该轮到我出栈了
//                        root = stack.pop();
//                        res.add(root.val);
//                        proot = root; //记录前一个出栈的节点
//                    } else {
//                        root = root.right;  //如果前节点不是右节点，那么证明还没轮到当前栈顶元素出栈，要想办法让右节点入栈然后出栈
//                        flag = false;//root左边孩子未被访问；   //这里标志当前节点的左节点还是没有访问过的，标记好，重新开始一轮
//                    }
//                }
//            } while (!stack.isEmpty());
//        }
        return res;

    }
}
