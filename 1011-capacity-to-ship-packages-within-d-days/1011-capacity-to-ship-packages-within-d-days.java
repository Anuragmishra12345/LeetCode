class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        while(low<=high){
            int mid=low+(high-low)/2;
            int day=findDays(weights,mid);
            if(day<=days) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int findDays(int[] weights,int cap){
        int days=1;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+load>cap){
                days++;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
}