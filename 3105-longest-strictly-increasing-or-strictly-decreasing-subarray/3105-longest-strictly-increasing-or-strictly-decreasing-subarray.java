class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int left1=0;
        int left2=0;

        int min=nums[0];
        int max=min;

        int result=1;

        for(int right=0;right<nums.length;right++){
            int curr=nums[right];

            if(curr>min){
                min=curr;
            }
            else {
                left1=right;
                min=curr;
            }

            if(curr<max){
                max=curr;
            }
            else{
                left2=right;
                max=min;
            }

            result=Math.max(result,right-left1+1);
            result=Math.max(result,right-left2+1);
        }

        return result;
    }
}