class Solution {
    public String smallestPalindrome(String s) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder left=new StringBuilder();
        StringBuilder middle=new StringBuilder();

        for(int index=0;index<26;index++){
            int f=freq[index];
            if(f==0) continue;

            int middleCount=f%2;
            int leftCount=f/2;

            if(leftCount!=0){
                for(int i=0;i<leftCount;i++){
                    left.append((char)(index+'a'));
                }
            }
            if(middleCount!=0) middle.append((char)(index+'a'));
        }
        String l=left.toString();
        middle.append(left.reverse());
        return l+middle.toString();
    }
}