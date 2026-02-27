class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack=new Stack();
        int depth=0;
        for(int i=0; i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(ch);
                depth=Math.max(depth,stack.size());
            }
            if(ch==')') stack.pop();
        }
        return depth;
    }
}