class Solution {
    Boolean[][] dp;
    boolean[][] isPal;
    public boolean checkPartitioning(String s) {
        int n=s.length();
        if(n<3) return false;
        dp=new Boolean[n][4];
        isPal=new boolean[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || isPal[i+1][j-1])) isPal[i][j]=true;
            }
        }

        return f(s,0,0);
    }
    boolean f(String s, int index, int parts){
        if(parts==3) return index==s.length();
        if (index == s.length()) return false;

        if(dp[index][parts]!=null) return dp[index][parts];

        for(int j=index;j<s.length();j++){
            if(isPal[index][j]){
                if(f(s,j+1,parts+1)){
                    return dp[index][parts]=true;
                }
                
            }
        }
        return dp[index][parts]=false;
    }
}