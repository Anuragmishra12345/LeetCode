class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans=0;

        for(int house:houses){

            int index=bSearch(heaters,house);

            int left=Integer.MAX_VALUE;
            int right=Integer.MAX_VALUE;

            if(index>=0){
                left=house-heaters[index];
            }
            
            if(index+1<heaters.length){
                right=heaters[index+1]-house;
            }

            ans=Math.max(ans,Math.min(left,right));
        }

        return ans;
    }
    int bSearch(int[] heaters, int house){
        int low=0;
        int high=heaters.length-1;

        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(heaters[mid]<=house){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
}