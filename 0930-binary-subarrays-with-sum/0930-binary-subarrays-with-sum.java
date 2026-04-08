class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    int atmost(int[] nums, int goal){
        int left=0;
        int count=0;
        for(int right=0;right<nums.length;right++){
            goal-=nums[right];
            while(goal<0 && left<=right){
                goal+=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}