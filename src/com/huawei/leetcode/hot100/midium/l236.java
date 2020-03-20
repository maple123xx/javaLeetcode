package com.huawei.leetcode.hot100.midium;

public class l236 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { //递归左右，都不为空说明一个在左，一个在右 此时返回root
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
