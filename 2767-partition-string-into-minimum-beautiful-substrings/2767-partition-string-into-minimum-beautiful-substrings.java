class Solution {
    int[] dp;
    public int minimumBeautifulSubstrings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        int ans=func(s,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    boolean isPowerOfFive(int num) {
        if(num<=0) return false;

        while(num%5==0) num/=5;

        return num==1;
    }

    int func(String s, int i){
        if(i==s.length()) return 0;

        if(dp[i]!=-1) return dp[i];

        if(s.charAt(i)=='0') return dp[i]=Integer.MAX_VALUE;

        int count=Integer.MAX_VALUE;
        int num=0;
        for(int j=i;j<s.length();j++){
            num=num*2+(s.charAt(j)-'0');
            if(isPowerOfFive(num)){
                int next=func(s,j+1);
                if(next!=Integer.MAX_VALUE) count=Math.min(count,1+next);
            }
        }
        return dp[i]=count;
    }
}