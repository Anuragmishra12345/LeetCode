class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] count=new int[n];
        int[] len=new int[n];
        int max=1;
        Arrays.fill(count,1);
        Arrays.fill(len,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && len[j]+1>len[i]){
                    len[i]=len[j]+1;
                    count[i]=count[j];
                }
                else if(nums[i]>nums[j] && len[j]+1==len[i]){
                    count[i]+=count[j];
                }
            }
            max=Math.max(max,len[i]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(len[i]==max) res+=count[i];
        }
        return res;
    }
}