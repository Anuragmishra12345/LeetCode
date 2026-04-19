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
    int min=Integer.MAX_VALUE;
    int secondMin=Integer.MAX_VALUE;
    boolean change=false;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return (change)?secondMin:-1;
    }
    void dfs(TreeNode root){
        if(root==null) return;
        if(root.val<=min) min=root.val;
        else {
            if(root.val<secondMin) secondMin=root.val;
            change=true;
        }

        dfs(root.left);
        dfs(root.right);
    }
}