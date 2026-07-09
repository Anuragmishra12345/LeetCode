class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();

        int[] dp=new int[n+1];

        for(int i=1;i<=n;i++){
            int[] currDp=new int[n+1];
            char ch1=s.charAt(i-1);
            for(int j=1;j<=n;j++){
                char ch2=s.charAt(n-j);
                if(ch1==ch2) currDp[j]=1+dp[j-1];
                else currDp[j]=Math.max(dp[j],currDp[j-1]);
            }
            dp=currDp;
        }
        return dp[n];
    }
    // int func(String s, int i , int j){

    //     if(i>j) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int take=0;

    //     if(s.charAt(i)==s.charAt(j)){
    //         if(i!=j) take=2+func(s,i+1,j-1);
    //         else take=1;
    //     }
    //     int notTake=Math.max(func(s,i+1,j),func(s,i,j-1));

    //     return dp[i][j]=Math.max(take,notTake);
    // }
}