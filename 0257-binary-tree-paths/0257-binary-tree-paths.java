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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        dfs(root, result, new StringBuilder(),0);
        return result;
        
    }
    void dfs(TreeNode root, List<String> result, StringBuilder curr, int prevlen){
        if(root==null) return ;
        prevlen=curr.length();
        curr.append(root.val);
        if(root.left!=null || root.right!=null) curr.append("->");
        if(root.left==null && root.right==null){
            result.add(curr.toString());
        }
        dfs(root.left,result,curr,prevlen);
        dfs(root.right, result, curr, prevlen);
        while(curr.length()-prevlen>0){
            curr.deleteCharAt(curr.length()-1);
        }
    }
}