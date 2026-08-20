class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1=new int[50];
        int[] arr2=new int[50];

        int i=1;
        int j=1;
        arr1[0]=nums[0];
        arr2[0]=nums[1];

        for(int it=2;it<nums.length;it++){
            int num=nums[it];
            if(arr1[i-1]>arr2[j-1]) {
                arr1[i]=num;
                i++;
            }
            else {
                arr2[j]=num;
                j++;
            }
        }
        int[] result=new int[nums.length];
        int index=0;

        for(int it=0;it<i;it++){
            result[index++]=arr1[it];
        }
        for(int it=0;it<j;it++){
            result[index++]=arr2[it];
        }
        return result;
    }
}