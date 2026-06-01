class Solution {
    public int minimumCost(int[] cost) {
        if(cost.length==1) return cost[0];
        Arrays.sort(cost);
        int sum=0;
        int i=cost.length-1;
        while(i>0){
            sum+=cost[i];
            sum+=cost[i-1];
            i-=3;
        }
        if(i==0) sum+=cost[i];
        return sum;
    }
}