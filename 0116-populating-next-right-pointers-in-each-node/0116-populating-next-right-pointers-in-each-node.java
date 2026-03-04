/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }
    private void dfs(Node root){
        if(root==null) return;
        Set<Node> set=new HashSet<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            Node curr=queue.poll();
            if(!set.contains(curr)){
                set.add(curr);
                if(curr.left!=null){
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            for(int i=1;i<size;i++){
                Node next=queue.poll();
                curr.next=next;
                curr=next;
                if(!set.contains(next)){
                set.add(next);
                if(next.left!=null){
                    queue.add(next.left);
                    queue.add(next.right);
                }
            }
            }
        }
    }
}