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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        postIndex=postorder.length-1;
        return build(postorder,map,0,postIndex);
    }
    private TreeNode build(int[] postOrder, Map<Integer,Integer> map, int start, int end){
        if(start>end) return null;

        int val=postOrder[postIndex--];
        TreeNode root=new TreeNode(val);
        int mid=map.get(val);

        root.right=build(postOrder,map,mid+1,end);
        root.left=build(postOrder,map,start,mid-1);
        return root;
    }
}