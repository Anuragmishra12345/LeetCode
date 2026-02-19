/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        Set<TreeNode> set=new HashSet<>();
        getParent(root,parent);

        q.add(target);
        set.add(target);
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(k==dist){
                List<Integer> result=new ArrayList<>();
                for(TreeNode node:q){
                    result.add(node.val);
                }
                return result;
            }
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && !set.contains(node.left) ){
                    q.add(node.left);
                    set.add(node.left);
                }
                if(node.right!=null && !set.contains(node.right)){
                    q.add(node.right);
                    set.add(node.right);
                } 
                if(parent.get(node)!=null && !set.contains(parent.get(node))){
                    q.add(parent.get(node));
                    set.add(parent.get(node));
                } 
            }
            dist++;
        }
        return new ArrayList<>();
    }
    void getParent(TreeNode root,Map<TreeNode , TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                parent.put(node.left,node);
                q.add(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                q.add(node.right);
            }
        }
    }
}