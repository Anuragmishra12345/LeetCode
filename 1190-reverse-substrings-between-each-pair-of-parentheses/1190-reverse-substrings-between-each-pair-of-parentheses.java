class Solution {
    int i=0;
    public String reverseParentheses(String s) {
        StringBuilder result=new StringBuilder();
        
        while(i<s.length()){
            if(s.charAt(i)!='('){
                result.append(s.charAt(i));
                i++;
            }
            else {
                result.append(simplifier(s));
            }
        }

        return result.toString();
    }
    String simplifier(String s){
        StringBuilder result=new StringBuilder();
        Deque<Character> stack=new ArrayDeque<>();

        while(i<s.length()){
            if(s.charAt(i)!=')') stack.push(s.charAt(i));
            else{
                StringBuilder curr=new StringBuilder();
                while(stack.peek()!='('){
                    curr.append(stack.pop());
                }
                stack.pop();
                if(stack.isEmpty()){
                    result.append(curr);
                    i++;
                    break;
                }
                else{
                    for(int j=0;j<curr.length();j++){
                        stack.push(curr.charAt(j));
                    }
                }
            }
            i++;
        }

        return result.toString();
    }
}