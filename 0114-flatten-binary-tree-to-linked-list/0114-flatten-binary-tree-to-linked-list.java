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
    List<TreeNode> list= new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null) return;
        preOrder(root);
        TreeNode curr=root;
        for(int i=1; i<list.size();i++){
            curr.right=list.get(i);
            curr.left=null;
            curr=curr.right;
        }
    }
    public void preOrder(TreeNode root){
        if(root==null) return;
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);  
    }
}