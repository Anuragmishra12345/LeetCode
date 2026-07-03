class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb= new StringBuilder();

        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
        }
        int left=0;
        int right=sb.length()-1;

        while(left<right){
            if(sb.charAt(left)!=sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}