class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack();

        for(char ch:num.toCharArray()){
            while(!stack.isEmpty() && k>0 && ch<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        
        while(k>0){
            stack.pop();
            k--;
        }

        for(char ch:stack){
            sb.append(ch);
        }

        while(0<sb.length() && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return (sb.length()==0)?"0":sb.toString();
    }
}