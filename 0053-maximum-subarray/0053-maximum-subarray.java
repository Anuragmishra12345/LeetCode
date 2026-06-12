class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum=nums[0];
        int maxSum=currentSum;
        for(int i=1;i<nums.length;i++){
            int n=nums[i];
            currentSum=Math.max(currentSum+n,n);
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}