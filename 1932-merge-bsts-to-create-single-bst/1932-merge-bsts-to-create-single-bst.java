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
    
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> leaves=new HashSet<>();
        TreeNode root=null;
        for(TreeNode node: trees){
            map.put(node.val,node);
            if(node.left!=null) leaves.add(node.left.val);
            if(node.right!=null) leaves.add(node.right.val);
        }

        for(TreeNode node:trees){
            if(!leaves.contains(node.val)){
                root=node;
                break;
            }
        }
        if(root==null) return null;
        
        if(!build(root,Long.MIN_VALUE, Long.MAX_VALUE,map)) return null;

        if(map.size()!=1) return null;

        return root;
    }

    boolean build(TreeNode node, long low, long high, Map<Integer,TreeNode> map){
        if(node==null) return true;

        if(node.val<=low || node.val>=high) return false;

        if(node.left==null && node.right==null && 
        map.containsKey(node.val) && map.get(node.val)!=node){
            TreeNode merge=map.get(node.val);
            node.left=merge.left;
            node.right=merge.right;
            map.remove(node.val);
        }

        return build(node.left,low,node.val,map) && build(node.right,node.val,high,map);
    }
}