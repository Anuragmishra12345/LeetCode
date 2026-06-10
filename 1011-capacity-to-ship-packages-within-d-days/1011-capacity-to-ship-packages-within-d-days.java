class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();

        while(low<=high){
            int mid=low+(high-low)/2;

            int d=findDays(weights,mid);
            if(d<=days) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int findDays(int[] w,int cap){
        int days=1;
        int load=0;
        for(int i=0;i<w.length;i++){
            if(w[i]+load>cap){
                days++;
                load=w[i];
            }
            else load+=w[i];
        }
        return days;
    }
}