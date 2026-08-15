class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack=new ArrayDeque<>();

        for(char ch:expression.toCharArray()){
            if(ch==',') continue;
            int t=0;
            int f=0;

            if(ch!=')') stack.push(ch);
            else{
                while(stack.peek()!='('){
                    char c=stack.pop();
                    if(c=='t') t++;
                    else f++;
                }
                stack.pop();
                char op=stack.pop();

                if(op=='!') {
                    stack.push((f>t)?'t':'f');
                }
                else if(op=='&'){
                    stack.push((f==0)?'t':'f');
                }
                else stack.push((t==0)?'f':'t');
            }
        }
        return (stack.peek()=='t')?true:false;
    }
}