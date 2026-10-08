class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result=new StringBuilder();

        int i=1;
        int open=0;

        int n=s.length();

        while(i<n){
            char ch=s.charAt(i);
            if(ch==')' && open==0){
                i+=2;
            }
            else{
                result.append(ch);
                if(ch=='(') open++;
                else open--;
                i++;
            }
        }
        return result.toString();
    }
}