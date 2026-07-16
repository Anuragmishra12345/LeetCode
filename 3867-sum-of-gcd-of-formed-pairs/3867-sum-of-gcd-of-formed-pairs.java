class Solution {
    public long gcdSum(int[] nums) {
        long sum=0;
        int max=nums[0];
        int[] prefixGcd=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=gcd(nums[i],max);
        }
        int left=0;
        int right=nums.length-1;
        Arrays.sort(prefixGcd);
        while(left<right){
            sum+=gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
    int gcd(int a , int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}