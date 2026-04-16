class Solution {
    List<String> result=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s,new HashSet<>(wordDict),0,"");
        return result;
    }
    public void backtrack(String s,Set<String> wordDict, int start, String curr){
        if(start==s.length()){
            result.add(curr);
            return;
        }
        for(int i=start;i<s.length();i++){
            String str=s.substring(start,i+1);
            if(wordDict.contains(str)){
                String next;
                if(curr.length()==0){
                    next=str;
                }
                else next=curr+" "+str;
                backtrack(s,wordDict,i+1,next);
            }
        }
    }
}