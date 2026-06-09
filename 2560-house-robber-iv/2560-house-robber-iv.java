class Solution {
    public int minCapability(int[] nums, int k) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int n : nums){
            low=Math.min(low,n);
            high=Math.max(high,n);
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(canRob(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    boolean canRob(int[] nums, int k, int cap){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=cap){
                i++;
                count++;
            }
            if(count>=k) return true;
        }
        return false;
    }
}