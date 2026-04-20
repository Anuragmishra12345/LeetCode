class Solution {
    int[] dp;

    public int minCut(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return f(s,0)-1;
    }
    int f(String s,int i){
        if(i>=s.length()) return 0;
        int minCost=Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                int cost=1+f(s,j+1);
                minCost=Math.min(minCost,cost);
            }
        }
        return dp[i]=minCost;
    }

    boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
} 