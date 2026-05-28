class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb=new StringBuilder(num);
        Stack<Character> stack=new Stack();

        int i=0;
        while(i<sb.length()){
            if(stack.isEmpty() || stack.peek()<=sb.charAt(i)){
                stack.push(sb.charAt(i));
                i++;
            }
            else if(k>0) {
                stack.pop();
                sb.deleteCharAt(i-1);
                i--;
                k--;
            }
            else break;
        }
        while(k>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        
        while(0<sb.length()){
            if(sb.charAt(0)=='0') sb.deleteCharAt(0);
            else break;
        }
        if(sb.length()==0) sb.append('0');
        return sb.toString();
    }
}