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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        traverse(q,0,root);
        while(!q.isEmpty()){
            result.add(q.poll());
        }
        return result;
    }
    void traverse(Queue<Integer> q, int level, TreeNode root){
        if(root==null) return;
        if(level==q.size()) q.add(root.val);

        traverse(q,level+1,root.right);
        traverse(q,level+1,root.left);
    }
}