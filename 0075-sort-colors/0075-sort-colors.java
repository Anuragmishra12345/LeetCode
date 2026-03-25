class Solution {
    public void sortColors(int[] nums){
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,mid,low);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
    public void swap(int[] nums,int first,int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
    // public void sortColors(int[] nums) {
    //     int zero=0;
    //     int one=0;
    //     int two=0;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]==0){
    //             zero++;
    //         }else if(nums[i]==1){
    //             one++;
    //         }else two++;
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if(zero>0){
    //             nums[i]=0;
    //             zero--;
    //         }else if(one>0){
    //             nums[i]=1;
    //             one--;
    //         }else{
    //             nums[i]=2;
    //             two--;
    //         }
    //     }
    // }
}