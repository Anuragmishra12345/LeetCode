class Solution {
    public int longestPalindromeSubseq(String s) {
        return lcs(s,new StringBuilder(s).reverse().toString());
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

    int lcs(String s1, String s2){
        int n1=s1.length();
        int n2=s2.length();

        int[] dp=new int[n1+1];

        for(int i=1;i<=n1;i++){
            int[] currDp=new int[n1+1];
            for(int j=1;j<=n1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) currDp[j]=1+dp[j-1];
                else currDp[j]=Math.max(dp[j],currDp[j-1]);
            }
            dp=currDp;
        }
        return dp[n1];
    }
}