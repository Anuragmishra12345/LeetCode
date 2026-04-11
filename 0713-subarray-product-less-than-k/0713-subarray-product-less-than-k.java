class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int total=1;
        int count=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            total*=nums[right];
            while(total>=k){
                total/=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}