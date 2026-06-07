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
    public TreeNode createBinaryTree(int[][] desc) {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();

        for(int[] d:desc){
            int p=d[0];
            int c=d[1];

            map.putIfAbsent(p,new TreeNode(p));
            map.putIfAbsent(c,new TreeNode(c));

            TreeNode parent=map.get(p);
            TreeNode child=map.get(c);

            if(d[2]==1){
                parent.left=child;
            }
            else parent.right=child;

            set.add(c);
        }
        TreeNode root=null;
        for(Map.Entry<Integer,TreeNode> entry:map.entrySet()){
            if(!set.contains(entry.getKey())) {
                root=entry.getValue();
                break;
            }
        }
        return root;
    }
}