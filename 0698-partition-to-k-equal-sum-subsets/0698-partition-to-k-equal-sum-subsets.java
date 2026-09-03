class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums) sum+=num;

        if(sum%k!=0) return false;

        int requiredSum=sum/k;
        boolean[] visited=new boolean[nums.length];

        return backtrack(nums,visited,0,0,requiredSum,k);
    }
    boolean backtrack(int[] nums, boolean[] visited,
                  int start, int currSum,
                  int target, int k) {

    if(k == 1)
        return true;

    if(currSum == target) {
        return backtrack(nums, visited, 0, 0,
                         target, k - 1);
    }

    for(int i = start; i < nums.length; i++) {

        if(visited[i] || currSum + nums[i] > target)
            continue;

        visited[i] = true;

        if(backtrack(nums, visited, i + 1,currSum + nums[i],target, k)) return true;

        visited[i] = false;
    }

    return false;
}
}