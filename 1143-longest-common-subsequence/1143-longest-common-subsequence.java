class Solution {
    int[][] dp; 
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int[text1.length()][text2.length()];
        for(int[] row:dp) Arrays.fill(row,-1);
        return func(text1,text2,0,0);
    }
    int func(String t1 ,String t2, int i ,int j){
        if(i==t1.length() || j==t2.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int take=0;

        if(t1.charAt(i)==t2.charAt(j)) take=1+func(t1,t2,i+1,j+1);

        int notTake=Math.max(func(t1,t2,i+1,j),func(t1,t2,i,j+1));
        
        return dp[i][j]=Math.max(take,notTake);
    }
}