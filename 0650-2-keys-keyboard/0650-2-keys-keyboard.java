class Solution {
    // int[][] dp;
    // public int minSteps(int n) {
    //     dp=new int[n+1][n+1];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     return func(n,1,0);
    // }
    // int func(int n, int A, int c){
    //     if(A==n) return 0;
    //     if(A>n) return Integer.MAX_VALUE;

    //     if(dp[A][c]!=-1) return dp[A][c]; 

    //     int copy=func(n,A+A,A);
    //     if(copy!=Integer.MAX_VALUE) copy+=2;

    //     int paste=Integer.MAX_VALUE;
    //     if(c!=0) paste=func(n,A+c,c);
    //     if(paste!=Integer.MAX_VALUE) paste+=1;

    //     return dp[A][c]=Math.min(copy,paste);
    // }

    public int minSteps(int n) {
        int sum=0;
        for(int i=2;i*i<=n;i++){
            while(n%i==0){
                sum+=i;
                n/=i;
            }
        }
        if(n>1) sum+=n;
        return sum;
    }
}