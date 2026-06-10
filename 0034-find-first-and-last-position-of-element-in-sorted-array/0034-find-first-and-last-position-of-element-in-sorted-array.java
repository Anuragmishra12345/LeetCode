class Solution {
    public int[] searchRange(int[] nums,int target){
        int[] ans={-1,-1};
        ans[0]=searchIndex(nums,target,true);
        ans[1]=searchIndex(nums,target,false);
        
        return ans;
    }

    public int searchIndex(int[] nums, int target, boolean startingIndex){
        int left=0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target) left=mid+1;
            else if(nums[mid]>target) right=mid-1;
            else {
                ans=mid;
                if(startingIndex) right=mid-1;
                else left=mid+1;
            }
        }
        return ans;
    }
}