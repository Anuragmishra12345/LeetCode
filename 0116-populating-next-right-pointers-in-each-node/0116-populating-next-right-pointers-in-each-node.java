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
        levelOrderTraversal(root);
        return root;
    }

    void levelOrderTraversal(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node prev=null;
            int size=q.size();

            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(prev!=null) prev.next=curr;
                prev=curr;
                if(prev.left!=null) q.add(prev.left);
                if(prev.right!=null) q.add(prev.right);
            }
        }
    }




























}