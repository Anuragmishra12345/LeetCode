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
    Map<TreeNode,Integer[]> memo=new HashMap<>();
    public int rob(TreeNode root) {
        return solve(root,0);
    }
    int solve(TreeNode root,int choose){
        if(root==null) return 0;

        memo.putIfAbsent(root,new Integer[2]);

        if(memo.get(root)[choose]!=null) return memo.get(root)[choose];

        int take=0;
        int notTake=0;
        if(choose==0){
            take=root.val+solve(root.left,1)+solve(root.right,1);
        }
        else{
            take=solve(root.left,0)+solve(root.right,0);
        }
        notTake=solve(root.left,0)+solve(root.right,0);

        return memo.get(root)[choose]=Math.max(take,notTake);
    }
}