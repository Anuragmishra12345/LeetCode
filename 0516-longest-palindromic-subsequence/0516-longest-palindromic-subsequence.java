class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        dp=new int[s.length()][s.length()];
        for(int[] row:dp) Arrays.fill(row,-1);
        return Math.max(1,func(s,0,s.length()-1));
    }
    int func(String s, int i , int j){

        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int take=0;

        if(s.charAt(i)==s.charAt(j)){
            if(i!=j) take=2+func(s,i+1,j-1);
            else take=1;
        }
        int notTake=Math.max(func(s,i+1,j),func(s,i,j-1));

        return dp[i][j]=Math.max(take,notTake);
    }
}