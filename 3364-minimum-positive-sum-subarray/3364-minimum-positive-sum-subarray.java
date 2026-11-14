class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int sum=Integer.MAX_VALUE;

        for(int i=1;i<nums.size();i++){
            nums.set(i,nums.get(i-1)+nums.get(i));
        }

        for(int size=l;size<=r;size++){
            for(int range=size-1;range<nums.size();range++){
                int currSum=-1;
                if(range==size-1) {
                    currSum=nums.get(range);
                }
                else{
                    currSum=nums.get(range)-nums.get(range-size);
                }
                if(currSum>0) {
                    sum=Math.min(sum,currSum);
                }
            }
        }
        return sum==Integer.MAX_VALUE?-1:sum;
    }
}