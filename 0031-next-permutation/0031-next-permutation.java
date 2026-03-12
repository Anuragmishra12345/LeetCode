class Solution {
    public void nextPermutation(int[] nums) {
        int index1=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index1=i-1;
                break;
            }
        }
        if(index1==-1){
            reverse(nums,0,nums.length-1);
            return;
        }

        int index2=-1;
        for(int j=nums.length-1;j>index1;j--){
            if(nums[j]>nums[index1]){
                index2=j;
                break;
            }
        }
        
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;

        reverse(nums,index1+1,nums.length-1);
        
    }
    public void reverse(int[] nums,int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}