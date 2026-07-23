class Solution {
    public int maxProduct(int[] nums) {
        int result=nums[0];
        int max=nums[0];
        int min=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            int curr=nums[i];

            if(curr<0){
                int temp=max;
                max=min;
                min=temp;
            }

            max=Math.max(curr,curr*max);
            min=Math.min(curr,curr*min);
            result=Math.max(result,max);
        }
        return result;
    }
}