class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int left1=0;
        int left2=0;

        int prev=nums[0];

        int result=1;

        for(int right=1;right<nums.length;right++){
            int curr=nums[right];

            if(curr<=prev){
                left1=right;
            }

            if(curr>=prev){
                left2=right;
            }

            prev=curr;

            result=Math.max(result,right-left1+1);
            result=Math.max(result,right-left2+1);
        }

        return result;
    }
}