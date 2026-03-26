class Solution {
    public int minDistance(String word1, String word2) {
        return word1.length()+word2.length()-(2*lcs(word1,word2));
    }
    int lcs(String s1, String s2){
        int n1=s1.length();
        int n2=s2.length();

        int[] dp=new int[n2+1];
        
        for(int i=1;i<=n1;i++){
            int[] curr=new int[n2+1];
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    curr[j]=1+dp[j-1];
                }
                else curr[j]=Math.max(curr[j-1],dp[j]);
            }
            dp=curr;
        }
        return dp[n2];
    }
}