class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()];
        Set<String> words=new HashSet<>();
        for(String word:wordDict) words.add(word);
        return func(s,words,0);
    }
    boolean func(String s, Set<String> words, int index){
        if(s.length()==index) return true;

        if(dp[index]!=null) return dp[index];

        for(int i=index+1;i<=s.length();i++){
            String word=s.substring(index,i);
            if(words.contains(word)){
                if(func(s,words,i)) return dp[index]=true;
            }
        }
        return dp[index]=false;
    }
}