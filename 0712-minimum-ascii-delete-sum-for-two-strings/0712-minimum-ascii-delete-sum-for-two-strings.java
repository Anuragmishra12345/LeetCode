class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp=new Integer[s1.length()+1][s2.length()+1];
        return solve(s1,s2,0,0);
    }
    int solve(String s1, String s2, int i, int j){
        if(i==s1.length() && j==s2.length()) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int ans=Integer.MAX_VALUE;

        if(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j)) ans=solve(s1,s2,i+1,j+1);
        else{
            int left=Integer.MAX_VALUE;
            if(i<s1.length()) left=s1.charAt(i) + solve(s1,s2,i+1,j);
            int right=Integer.MAX_VALUE;
            if(j<s2.length()) right=s2.charAt(j) + solve(s1,s2,i,j+1);

            ans=Math.min(ans,Math.min(left,right));
        }
        return dp[i][j]=ans;
    }
}