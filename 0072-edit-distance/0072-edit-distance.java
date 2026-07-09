class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()][word2.length()];
        for(int[] row:dp) Arrays.fill(row,-1);
        return func(word1,word2,0,0);
    }
    int func(String s1 , String s2 , int i , int j){
        if(j==s2.length()) return s1.length()-i;
        if(i==s1.length()) return s2.length()-j;

        if(dp[i][j]!=-1) return dp[i][j];

        int doNothing=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)) doNothing=func(s1,s2,i+1,j+1);

        int replace =1+func(s1,s2,i+1,j+1);
        int remove=1+func(s1,s2,i+1,j);
        int insert=1+func(s1,s2,i,j+1);

        return dp[i][j]=Math.min(doNothing,Math.min(replace,Math.min(remove,insert)));
    }
}