class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        boolean[][] isPalindrome=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1) isPalindrome[i][j]=true;
                    else isPalindrome[i][j]=isPalindrome[i+1][j-1];
                }
            }
        }

        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {

            dp[i] = dp[i + 1];

            for(int j = i + k - 1; j < n; j++) {

                if(isPalindrome[i][j]) {

                    dp[i] = Math.max(
                        dp[i],
                        1 + dp[j + 1]
                    );
                }
            }
        }

        return dp[0];
    }
}