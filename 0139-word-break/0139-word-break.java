class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()];
        Set<String> set=new HashSet<>();
        for(String str:wordDict) set.add(str);

        return backtrack(s,0,set);
    }
    boolean backtrack(String s, int index, Set<String> set){
        if(index==s.length()) return true;
        if(dp[index]!=null) return dp[index];
        for(int i=index;i<s.length();i++){
            String curr=s.substring(index,i+1);
            if(set.contains(curr)){
                if(backtrack(s,i+1,set)) return true;
            }
        }
        return dp[index]=false;
    }
}