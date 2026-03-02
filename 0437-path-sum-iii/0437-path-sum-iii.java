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
    public int pathSum(TreeNode root, int targetSum) {
       if(root==null) return 0;
       dfs(root,targetSum);
       pathSum(root.left,targetSum);
       pathSum(root.right,targetSum);
       return ans;
    }
    void dfs(TreeNode root, long target){
        if(root==null) return ;
        if(target==root.val) ans++;

        dfs(root.left,target-root.val);
        dfs(root.right,target-root.val);
    }
}