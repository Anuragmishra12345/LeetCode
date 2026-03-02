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
    //    if(root==null) return 0;
    //    dfs(root,targetSum);
    //    pathSum(root.left,targetSum);
    //    pathSum(root.right,targetSum);
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        dfs(root,0,targetSum,map);
       return ans;
    }
    // void dfs(TreeNode root, long target){
    //     if(root==null) return ;
    //     if(target==root.val) ans++;

    //     dfs(root.left,target-root.val);
    //     dfs(root.right,target-root.val);
    // }

    void dfs(TreeNode root, long currSum, int target, Map<Long,Integer> map){
        if(root==null) return;
        currSum+=root.val;
        ans+=map.getOrDefault(currSum-target,0);

        map.put(currSum,map.getOrDefault(currSum,0)+1);

        dfs(root.left, currSum, target, map);
        dfs(root.right, currSum, target, map);

        map.put(currSum,map.get(currSum)-1);
    }
}