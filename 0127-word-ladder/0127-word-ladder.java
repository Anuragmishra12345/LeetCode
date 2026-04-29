class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word=q.peek().word;
            int level=q.peek().level;
            q.remove();

            if(word.equals(endWord)) return level;

            for(int i=0;i<word.length();i++){
                char[] wordArray=word.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    wordArray[i]=ch;
                    if(set.contains(new String(wordArray))){
                        q.add(new Pair(new String(wordArray),level+1));
                        set.remove(new String(wordArray));
                    }
                }
            }
        }
        return 0;
    }
}
class Pair{
    String word;
    int level;

    Pair(String word, int value){
        this.word=word;
        this.level=value;
    }
}