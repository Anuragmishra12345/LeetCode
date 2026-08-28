class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int i=0;
        int n=nums.size();
        int j=n/2;
        int k=0;
        while(i<n/2 && j<n){
            if(nums.get(i)<nums.get(j)){
                i++;
                j++;
                k++;
            }
            else j++;
        }
        return n-2*k;
    }
}