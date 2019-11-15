package com.gapon.leetcode.algorithm.treeNode;

import java.util.List;

public class ValidBST {
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(root.left != null){
            System.out.println(" root.left " + root.left.val);
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        System.out.println(" root " + root.val);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        System.out.println(" pre "+ pre.val);
        if(root.right != null){
            System.out.println(" root.right " + root.right.val);
        }
        return isValidBST(root.right);
    }
    public static void main(String[] args) {
        ValidBST inorderTraversal = new ValidBST();
        //[1,null,2,3]
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);

        System.out.println(inorderTraversal.isValidBST(treeNode));
    }

}
