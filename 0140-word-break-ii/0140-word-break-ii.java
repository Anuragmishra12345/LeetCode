class Solution {
    List<String> result=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words=new HashSet<>(wordDict);

        backtrack(s,words,"",0);

        return result;
    }
    void backtrack(String s,Set<String> words,String curr, int index){
        if(index==s.length()) {
            result.add(curr);
            return;
        }
        
        for(int i=index+1;i<=s.length();i++){
            String word=s.substring(index,i);
            if(words.contains(word)){
                String next;
                if(curr.length()==0) next=word;
                else next=curr+" "+word;
                
                backtrack(s,words,next,i);
            }
        }
    }
    
}