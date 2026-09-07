class Solution {
    public void moveZeroes(int[] nums) {
        int first=0;
        int second=0;
        while(second<nums.length){
            if(nums[second]!=0){
                int temp=nums[first];
                nums[first]=nums[second];
                nums[second]=temp;
                first++;
            }
            second++;
            
        }
    }
}