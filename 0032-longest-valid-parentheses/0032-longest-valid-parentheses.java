class Solution {
    public int longestValidParentheses(String s) {
        int maxLen=0;
        int n=s.length();

        int open=0;
        int close=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') open++;
            else close++;

            if(open==close) maxLen=Math.max(maxLen,open*2);
            else if(close>open) open=close=0;
        }

        open=close=0;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='(') open++;
            else close++;

            if(open==close) maxLen=Math.max(maxLen,open*2);
            else if(close<open) open=close=0;
        }

        return maxLen;
    }
}