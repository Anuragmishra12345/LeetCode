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
    int ans=0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
    int dfs(TreeNode node){
        if(node==null) return 0;

        int leftChain=dfs(node.left);
        int rightChain=dfs(node.right);

        int leftPath=0; int rightPath=0;

        if(node.left!=null && node.left.val==node.val){
            leftPath=leftChain+1;
        }
        if(node.right!=null && node.right.val==node.val){
            rightPath=rightChain+1;
        }

        ans=Math.max(ans,leftPath+rightPath);

        return Math.max(leftPath,rightPath);
    }
}