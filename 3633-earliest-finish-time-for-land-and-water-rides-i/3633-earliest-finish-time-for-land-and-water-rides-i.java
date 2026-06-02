class Solution {
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return (int) ans;
    }

    public long solve(int[] land, int[] ld, int[] water, int[] wd){
        long ans=Long.MAX_VALUE;
        for(int i=0;i<land.length;i++){
            for(int j=0;j<water.length;j++){
                int start=land[i]+ld[i];
                int curr=Math.max(start,water[j])+wd[j];
                ans=Math.min(ans,curr);
            }
        }
        return ans;
    }
}