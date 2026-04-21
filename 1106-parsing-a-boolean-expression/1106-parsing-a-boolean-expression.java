class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack=new Stack<>();

        for(char ch:expression.toCharArray()){
            if(ch==',') continue;
            if(ch!=')') stack.push(ch);
            else {
                int t=0;
                int f=0;
                while(stack.peek()!='('){
                    char top=stack.pop();
                    if(top=='t') t++;
                    else f++;
                }
                stack.pop();
                char op=stack.pop();
                if(op=='!'){
                    stack.push((t>f)?'f':'t');
                }
                else if(op=='&'){
                    if(f==0) stack.push('t');
                    else stack.push('f');
                }
                else {
                    if(t==0) stack.push('f');
                    else stack.push('t');
                }
            }
        }
        return (stack.peek()=='t')?true:false;
    }
}