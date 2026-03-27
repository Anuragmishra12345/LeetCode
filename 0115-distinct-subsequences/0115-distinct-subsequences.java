class Solution {
    int[] dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[m+1];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return f(n-1, m-1, s,t);
        dp[0]=1;

        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            curr[0]=1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)) curr[j]=dp[j-1]+dp[j];
                else curr[j]=dp[j];
            }
            dp=curr;
        }
        return dp[m];
    }
    // int f(int i , int j , String a, String b){
    //     if(j<0) return 1;
    //     if(i<0) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     if(a.charAt(i)==b.charAt(j)) return dp[i][j]= f(i-1, j-1, a, b)+f(i-1,j,a,b);
    //     else return dp[i][j]=f(i-1,j,a,b);
    // }
}