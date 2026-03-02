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
    public int sumNumbers(TreeNode root) {
        return sum(root,0,0);
    }
    public int sum(TreeNode root, int finalSum, int currSum){
        if(root==null) return finalSum;
        currSum=currSum*10+root.val;
        if(root.right==null && root.left==null){
            finalSum+=currSum;
        }
        finalSum=sum(root.left,finalSum,currSum);
        finalSum=sum(root.right,finalSum,currSum);
        return finalSum;
    }
}