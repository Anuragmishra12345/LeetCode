class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int currMax=0;
        int currMin=0;
        int total=0;

        for(int i=0;i<n;i++){
            int num=nums[i];
            total+=num;
            currMax=Math.max(currMax+num,num);
            maxSum=Math.max(maxSum,currMax);
            currMin=Math.min(currMin+num,num);
            minSum=Math.min(minSum,currMin);
        }
        
        
        return maxSum<0?maxSum:Math.max(maxSum,total-minSum);
    }
}