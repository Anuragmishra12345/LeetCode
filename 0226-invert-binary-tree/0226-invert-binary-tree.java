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
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
    void swap(TreeNode root){
        if(root==null) return;
        TreeNode temp=null;
        if(root.left!=null){
            temp=root.left;
        }
        if(root.right!=null){
            root.left=root.right;
            root.right=temp;
        }
        else {
            root.right=temp;
            root.left=null;
        }

        swap(root.left);
        swap(root.right);
    }
}