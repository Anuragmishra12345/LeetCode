class Solution {
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
       int total=0;
       for(int s:stones) total+=s;

       int target=total/2;

       dp=new int[stones.length][target+1];

       for(int[] d:dp) Arrays.fill(d,-1);

       int best=solver(stones,0,0,target);

       return total-2*best;
    }
    int solver(int[] stones,int i, int sum, int target){
        if(i==stones.length) return sum;

        if(dp[i][sum]!=-1) return dp[i][sum];

        int notTake=solver(stones,i+1,sum,target);

        int take=0;

        if(sum+stones[i]<=target){
            take=solver(stones,i+1,sum+stones[i],target);
        }

        return dp[i][sum]=Math.max(take,notTake);
    }
}