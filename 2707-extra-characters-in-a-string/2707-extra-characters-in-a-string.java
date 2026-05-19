class Solution {
    int[] dp;
    Set<String> set;
    public int minExtraChar(String s, String[] dictionary) {
        set=new HashSet<>();
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        for(String st:dictionary) set.add(st);
        return solve(0,s);
    }

    int solve(int index, String s){
        if(index==s.length()) return 0;

        if(dp[index]!=-1) return dp[index];

        int ans=1+solve(index+1,s);

        for(int i=index;i<s.length();i++){
            String curr=s.substring(index,i+1);

            if(set.contains(curr)){
                ans=Math.min(ans,solve(i+1,s));
            }
        }

        return dp[index]=ans;
    }
}