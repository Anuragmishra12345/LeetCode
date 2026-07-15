class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int min=Integer.MAX_VALUE;
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int n:nums){
            min=Math.min(min,n);
            if(n>largest){
                secondLargest=largest;
                largest=n;
            }
            else if(n==largest){
                secondLargest=n;
            }
            else if(n>secondLargest){
                secondLargest=n;
            }
        }
        return largest+secondLargest-min;
    }
}