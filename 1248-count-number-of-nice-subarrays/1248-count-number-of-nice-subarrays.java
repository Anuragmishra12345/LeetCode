class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    int atmost(int[] nums, int k){
        int left=0;
        int result=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]%2!=0) k--;
            while(k<0){
                if(nums[left]%2!=0) k++;
                left++;
            }
            result+=right-left+1;
        }
        return result;
    }
}