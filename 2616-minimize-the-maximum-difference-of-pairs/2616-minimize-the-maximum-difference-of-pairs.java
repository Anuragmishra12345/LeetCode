class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p==0) return 0;
        Arrays.sort(nums);

        int low=0;
        int high=nums[nums.length-1]-low;

        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(check(nums,p,mid)){
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
    boolean check(int[] nums, int p, int space){
        int i=0;
        int j=1;

        while(j<nums.length){
            if(nums[j]-nums[i]<=space) {
                p--;
                i+=2;
                j+=2;
            }
            else{
                i++;
                j++;
            }
            if(p==0) return true;
        }
        return false;
    }
}