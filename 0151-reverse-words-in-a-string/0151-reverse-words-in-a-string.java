class Solution {
    public String reverseWords(String s) {
        String[] words=s.strip().split("\\s+");
        int left=0;
        int right=words.length-1;
        while(left<right){
            String word=words[left];
            words[left]=words[right];
            words[right]=word;
            left++;
            right--;
        }
        return String.join(" ",words);
    }
}