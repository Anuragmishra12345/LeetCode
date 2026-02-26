class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int low=1;
        // int high=0;

        // for(int p:piles) high=Math.max(high,p);

        // while(low<high){
        //     int mid=low+(high-low)/2;
        //     long hour=0;
        //     for(int p:piles) hour+=(p+mid-1)/mid;
            
        //     if(hour<=h) high=mid;
        //     else low=mid+1;
        // }
        // return low;

        int low=1;
        int high=0;
        for(int p:piles) high=Math.max(high,p);

        while(low<high){
            int mid=low+(high-low)/2;
            int hour=0;
            for(int p:piles) hour+=(p+mid-1)/mid;

            if(hour<=h) high=mid;
            else low=mid+1;
        }
        return low;
    }
}