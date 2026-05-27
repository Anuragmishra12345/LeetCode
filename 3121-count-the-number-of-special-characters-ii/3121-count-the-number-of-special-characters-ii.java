class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set=new HashSet<>();
        Set<Character> res=new HashSet<>();

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);

            if(Character.isUpperCase(ch)){
                if(!set.contains(ch)) set.add(ch);
            }
            else{
                if(set.contains(Character.toUpperCase(ch))){
                    res.remove(ch);
                }
                else res.add(ch);
            }
        }
        int length=res.size();
        for(char ch:res){
            if(!set.contains(Character.toUpperCase(ch))) length--;
        }
        return length;
    }
}