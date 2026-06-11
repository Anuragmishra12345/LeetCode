class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low=1;
        int high=0;
        for(int q:quantities){
            high=Math.max(high,q);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int store=canDistribute(quantities,mid);
            
            if(store>n){
                low=mid+1;
            }
            else {
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    int canDistribute(int[] nums, int k){
        int store=0;
        for(int n:nums){
           store+=(n+k-1)/k;
        }
        return store;
    }
}