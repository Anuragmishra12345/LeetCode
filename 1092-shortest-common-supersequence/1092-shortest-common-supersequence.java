class Solution {
    int[][] dp;
    public String shortestCommonSupersequence(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();

        dp=new int[n1+1][n2+1];
        // for (int[] row : dp) Arrays.fill(row, -1);

        // f(s1,s2,n1,n2);

        for(int i=1; i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        return subSequence(n1,n2,s1,s2);
    }
    int f(String s1, String s2, int i, int j){
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i-1)==s2.charAt(j-1)) return dp[i][j]=1+f(s1,s2,i-1,j-1);

        return dp[i][j]=Math.max(f(s1,s2,i-1,j),f(s1,s2,i,j-1));
    }
    String subSequence(int i, int j, String s1, String s2){
        StringBuilder result=new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                result.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1]>dp[i-1][j]){
                result.append(s2.charAt(j-1));
                j--;
            }
            else {
                result.append(s1.charAt(i-1));
                i--;
            }
        }
        while (i > 0) result.append(s1.charAt(--i));
        while (j > 0) result.append(s2.charAt(--j));

        return result.reverse().toString();
    }
}