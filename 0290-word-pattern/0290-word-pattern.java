class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> wordMap=new HashMap<>();
        Map<String,Character> charMap=new HashMap<>();
        String[] words=s.split(" ");
        if(words.length!=pattern.length()) return false;
        for(int i=0;i<words.length;i++){
            char ch=pattern.charAt(i);
            String word=words[i];
            if(wordMap.containsKey(ch)){
                if(!wordMap.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                wordMap.put(ch, word);
            }

            if(charMap.containsKey(word)){
                if(charMap.get(word) != ch){
                    return false;
                }
            }
            else{
                charMap.put(word, ch);
            }
        }
        return true;
    }
}