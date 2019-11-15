package com.gapon.leetcode.algorithm.treeNode;


import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List< Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
    public List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack< >();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
    public boolean helper2(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (! helper2(node.right, val, upper)) {
            return false;
        }
        return helper2(node.left, lower, val);
    }

    public boolean isValidBST(TreeNode root) {
        return helper2(root, null, null);
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        //[1,null,2,3]
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left =  new TreeNode(3);
        List< Integer > list = inorderTraversal.inorderTraversal2(treeNode);
        for (Integer i:list){
            System.out.println(i);
        }

    }

}
