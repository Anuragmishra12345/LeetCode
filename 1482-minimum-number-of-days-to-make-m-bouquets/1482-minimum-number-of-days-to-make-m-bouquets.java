class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long need=(long)m*k;
        if(need>bloomDay.length) return -1;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int b:bloomDay){
            low=Math.min(b,low);
            high=Math.max(b,high);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canMake(bloomDay,m,k,mid)){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
    public boolean canMake(int[] bloomDay,int m, int k, int day){
        int bouquets=0; int count=0;
        for(int d:bloomDay){
            if(d<=day){
                count++;
                if(count==k){
                    bouquets++;
                    count=0;
                }
            }
            else count=0;
        }
        return bouquets>=m;
    }
}