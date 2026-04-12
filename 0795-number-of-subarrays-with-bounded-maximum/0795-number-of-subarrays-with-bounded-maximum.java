class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums,right)-count(nums,left-1);
    }
    int count(int[] nums, int bound){
        int count=0;
        int curr=0;
        for(int num:nums){
            if(num<=bound) curr++;
            else curr=0;
            count+=curr;
        }
        return count;
    }
}