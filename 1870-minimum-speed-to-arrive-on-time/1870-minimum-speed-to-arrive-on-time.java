class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour <= dist.length - 1)
    return -1;
        int low=1;
        int high = 10_000_000;
        
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            double time = find(dist, mid);
            
            if(time<=hour){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    double find(int[] nums, int speed){
        double hour=0;
         for(int i = 0; i < nums.length - 1; i++){
            hour+= Math.ceil((double)nums[i] / speed);
        }
        hour+=(double)nums[nums.length-1]/speed;
        return hour;
    }
}