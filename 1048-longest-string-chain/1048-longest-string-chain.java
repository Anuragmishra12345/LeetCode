class Solution {
    public int longestStrChain(String[] words) {
        int max=1;
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(possible(words[i],words[j]) && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public boolean possible(String a, String b){
        int n= a.length();
        int m= b.length();
        if(n!=m+1) return false;
        int i=0;;
        int j=0;
        while(i<n && j<m){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }
            else i++;
        }
        
        return j==m;
    }
}