class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low=1;
        int high=maxSum;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(checkMax(n,index,maxSum,mid)){
                low=mid+1;
                ans=mid;
            }
            else high=mid-1;
        }
        return ans;
    }
    boolean checkMax(int n, int index, int maxSum, int peak){
        long left=calc(peak-1,index);
        long right=calc(peak-1,n-index-1);
        
        long total=left+right+peak;
        return total<=maxSum;
    }

    long calc(long peak,long len){
        if(peak>=len){
            long first=peak-len+1;
            return (first + peak) * 1L * len / 2;
        }
        long sum=(1+peak)*peak/2;
        return sum+len-peak;
    }
}