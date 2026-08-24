/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        func(root);
        return diameter;
    }
    private int func(TreeNode root){
        if(root==null) return 0;

        int right=func(root.right);
        int left=func(root.left);

        diameter=Math.max(diameter,right+left);
        return 1+Math.max(left,right);
    }
}