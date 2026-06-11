class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long low=1;
        long high=(long)time[0]*totalTrips;

        while(low<=high){
            long mid=low+(high-low)/2;
            long trips=find(time,mid);

            if(trips>=totalTrips){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
    long find(int[] nums, long time){
        long trips=0;
        for(int n:nums){
            trips+=time/n;
        }
        return trips;
    }
}