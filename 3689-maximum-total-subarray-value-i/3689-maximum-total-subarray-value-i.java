class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long value=0;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int n:nums){
            low=Math.min(low,n);
            high=Math.max(high,n);
        }
        value=Math.max(value,high-low);
        return value*k;
    }
}