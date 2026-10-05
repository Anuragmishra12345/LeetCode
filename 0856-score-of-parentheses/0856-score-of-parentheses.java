class Solution {
    int index=0;
    public int scoreOfParentheses(String s) {
        return solver(s);
    }
    int solver(String s){
        int result=0;
        while(index<s.length() && s.charAt(index)!=')'){
            index++;
            if(s.charAt(index)==')') {
                result++;
                index++;
            }
            else{
                result+=2*solver(s);
                index++;
            }
        }
        return result;
    }
}