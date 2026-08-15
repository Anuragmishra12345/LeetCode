class Solution {
    // int[] dp;
    // public int minCut(String s) {
    //     dp=new int[s.length()];
    //     Arrays.fill(dp,-1);
    //     return func(s,0)-1;
    // }
    // int func(String s, int i){
    //     if(i>=s.length()) return 0;

    //     if(dp[i]!=-1) return dp[i];

    //     int cost=Integer.MAX_VALUE;

    //     for(int j=i;j<s.length();j++){
    //         if(isPalindrome(s,i,j)){
    //             int c=1+func(s,j+1);
    //             cost=Math.min(cost,c);
    //         }
    //     }
    //     return dp[i]=cost;
    // }

    boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n+1];

        boolean[][] palindrome=new boolean[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=1 || palindrome[i+1][j-1])){
                    palindrome[i][j]=true;
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            int cost=Integer.MAX_VALUE;

            for(int j=i;j<n;j++){
                if(palindrome[i][j]){
                    int c=1+dp[j+1];
                    cost=Math.min(cost,c);
                }
            }
            dp[i]=cost;
        }
        return dp[0]-1;
    }
}