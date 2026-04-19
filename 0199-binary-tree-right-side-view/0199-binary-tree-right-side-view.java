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
    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return result;
    }
//     void traverse(List<Integer> result, int level, TreeNode root){
//         if(root==null) return;
//         if(level==result.size()) result.add(root.val);

//         traverse(result,level+1,root.right);
//         traverse(result,level+1,root.left);
//     }

    void dfs(TreeNode root,int level){
        if(root==null) return;
        if(level==result.size()) result.add(root.val);

        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}