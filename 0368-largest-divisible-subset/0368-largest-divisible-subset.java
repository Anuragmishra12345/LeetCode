class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int lastIndex=0;
        int max=1;

        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lastIndex=i;
            }
        }

        List<Integer> result=new ArrayList<>();
        while(hash[lastIndex]!=lastIndex){
            result.add(nums[lastIndex]);
            lastIndex=hash[lastIndex];
        }
        result.add(nums[lastIndex]);
        Collections.reverse(result);
        return result;
    }
}