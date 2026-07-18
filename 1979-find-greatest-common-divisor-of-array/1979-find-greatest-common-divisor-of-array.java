class Solution {
    public int findGCD(int[] nums) {
        int smallest =Integer.MAX_VALUE;
        int largest= Integer.MIN_VALUE;

        for(int n:nums){
            largest=Math.max(largest,n);
            smallest=Math.min(smallest,n);
        } 
        while(largest!=0){
            int temp =largest;
            largest=smallest%largest;
            smallest=temp;
        }
        return smallest;
    }
}