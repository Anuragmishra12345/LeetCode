class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;

        for(int n:nums){
            low=Math.max(low,n);
            high+=n;
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            int split=findSplit(nums,mid);
            if(split<=k) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    int findSplit(int[] nums, int max){
        int split=1;
        int m=0;
        for(int n:nums){
            if(n+m>max){
                split++;
                m=n;
            }
            else {
                m+=n;
            }

        }
        return split;
    }
}