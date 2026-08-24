class Solution {
    Integer[] dp;
    public int stoneGameVIII(int[] stones) {
        dp=new Integer[stones.length];

        for(int i=1;i<stones.length;i++){
            stones[i]=stones[i]+stones[i-1];
        }

        return func(stones,1);
    }
     private int func(int[] prefix, int i) {
        if(i==prefix.length-1) return prefix[i];

        if(dp[i]!=null)  return dp[i];
        int take=prefix[i]-func(prefix,i+1);
        int notTake=func(prefix,i+1);

        return dp[i]=Math.max(take,notTake);
    }
}