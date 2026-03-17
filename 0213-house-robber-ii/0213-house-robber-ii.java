class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int first=compute(nums,0,n-2);
        int second=compute(nums,1,n-1);

        return Math.max(first,second);
    }

    public int compute(int[] nums,int start, int end){
        int prev2=0;
        int prev1=nums[start];

        for(int i=start+1;i<=end;i++){
            int curr=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}