class Solution {
    public int maxLength(int[] nums) {
        int result=0;

        for(int i=0;i<nums.length;i++){
            int product=1;
            int g=0;
            int l=1;

            for(int j=i;j<nums.length;j++){
                product*=nums[j];
                
                g=gcd(g,nums[j]);
                l=lcm(l,nums[j]);

                if(product==g*l) result=Math.max(result,j-i+1);
            }
        }
        return result;
    }
    int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    int lcm(int x, int y){
        if(x==0 || y==0) return 0;

        return Math.abs(x/gcd(x,y))*Math.abs(y);
    }
}