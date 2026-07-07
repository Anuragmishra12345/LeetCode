class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        int tank=0;
        int index=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            tank+=gas[i]-cost[i];
            if(tank<0) {
                tank=0;
                index=i+1;
            }
        }
        return total<0?-1:index;
    }
}