class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) nums[i]=nums[i]*(-1);
        }
        Arrays.sort(nums);
        long ans=0;

        int i=nums.length/2;
        while(i<nums.length){
            ans+=nums[i]*nums[i];
            i++;
        }

        i=0;
        while(i<nums.length/2){
            ans-=nums[i]*nums[i];
            i++;
        }
        return ans;
    }
}