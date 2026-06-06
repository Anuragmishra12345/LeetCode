class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] ls=new int[n];
        int[] rs=new int[n];
        ls[0]=nums[0];
        rs[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            ls[i]=nums[i]+ls[i-1];
            rs[n-i-1]=nums[n-i-1]+rs[n-i];
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=Math.abs(ls[i]-rs[i]);
        }
        return res;
    }
}