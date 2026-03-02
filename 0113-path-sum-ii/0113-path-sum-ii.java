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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        dfs(root,result,new ArrayList<>(), targetSum,0);
        return result;
    }
    void dfs(TreeNode root, List<List<Integer>> result, List<Integer> curr, int target, int sum){
        if(root==null) return;
        sum+=root.val;
        curr.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target){
                result.add(new ArrayList<>(curr));
            }
            curr.remove(curr.size()-1);
            return;
        }
        dfs(root.left,result,curr,target,sum);
        dfs(root.right,result,curr,target,sum);

        curr.remove(curr.size()-1);
    }
}