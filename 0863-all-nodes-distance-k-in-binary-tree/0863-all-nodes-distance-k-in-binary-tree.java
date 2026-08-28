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
    List<Integer> result=new ArrayList<>();
    Set<TreeNode> visited=new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent =new HashMap<>();
        buildParent(root,parent);
        dfs(target,k,parent);
        return result;
    }
    void buildParent(TreeNode root, Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                parent.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                q.offer(node.right);
            }
        }
    }

    void dfs(TreeNode root, int k,Map<TreeNode,TreeNode> map){
        if(root==null || visited.contains(root)) return;
        if(k==0) result.add(root.val);
        visited.add(root);
        if(map.containsKey(root)){
            dfs(map.get(root),k-1,map);
        }
        if(root.left!=null) dfs(root.left,k-1,map);
        if(root.right!=null) dfs(root.right,k-1,map);

    }
}