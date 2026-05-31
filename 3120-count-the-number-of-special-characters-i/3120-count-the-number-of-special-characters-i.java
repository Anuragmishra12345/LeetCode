class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set1=new HashSet<>();
        Set<Character> set2=new HashSet<>();

        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)){
                set1.add(ch);
            }
            else set2.add(ch);
        }
        int count=0;
        for(char ch:set1){
            if(set2.contains(Character.toUpperCase(ch))) count++;
        }
        return count;
    }
}