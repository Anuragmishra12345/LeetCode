class Solution {
    // Integer[] dp;
    // public int stoneGameVIII(int[] stones) {
    //     dp=new Integer[stones.length];

    //     for(int i=1;i<stones.length;i++){
    //         stones[i]=stones[i]+stones[i-1];
    //     }

    //     return func(stones,1);
    // }
    //  private int func(int[] prefix, int i) {
    //     if(i==prefix.length-1) return prefix[i];

    //     if(dp[i]!=null)  return dp[i];
    //     int take=prefix[i]-func(prefix,i+1);
    //     int notTake=func(prefix,i+1);

    //     return dp[i]=Math.max(take,notTake);
    // }

    public int stoneGameVIII(int[] stones) {
        int[] dp=new int[stones.length];

        for(int i=1;i<stones.length;i++){
            stones[i]=stones[i]+stones[i-1];
        }
        dp[stones.length-1]=stones[stones.length-1];

        for(int i=stones.length-2;i>=1;i--){
            dp[i]=Math.max(stones[i]-dp[i+1],dp[i+1]);
        }
        return dp[1];
    }
}