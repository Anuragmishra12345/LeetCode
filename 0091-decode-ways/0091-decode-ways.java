class Solution {
    int[] dp;
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;

        dp=new int[s.length()];
        Arrays.fill(dp,-1);

        return func(s,0);
    }
    int func(String s, int index){
        if(index==s.length()) return 1;

        if(dp[index]!=-1) return dp[index];

        int one=0;
        if(s.charAt(index)!='0') one=func(s,index+1);

        int two=0;

        if(index<s.length()-1 && Integer.parseInt(s.substring(index,index+2))<=26 && s.charAt(index)!='0') {
            two=func(s,index+2);
        }

        return dp[index]=one+two;
    }
}