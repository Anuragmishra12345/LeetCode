class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        return lcs(s,s2);
    }
    int lcs(String text1, String text2){
        int n1=text1.length();
        int n2=text2.length();

        int[] dp=new int[n2+1];
        for(int j=0;j<=n2;j++) dp[j]=0;

        for(int i=1;i<=n1;i++){
            int[] curr=new int[n2+1];
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) curr[j]=1+dp[j-1];

                else curr[j]=Math.max(dp[j],curr[j-1]);
            }
            dp=curr;
        } 
        return dp[n2]; 
    }
}