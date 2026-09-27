class Solution {
    public boolean validPalindrome(String s) {
        return recursion(s,0,s.length()-1,false);
    }
    boolean recursion(String s, int i, int j, boolean remove){

        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else if(remove) return false;
            else{
                boolean answer=false;
                if(s.charAt(i)==s.charAt(j-1)){
                    j--;
                    answer=recursion(s,i,j,true);
                    j++;
                }
                if(s.charAt(i+1)==s.charAt(j)){
                    i++;
                    answer=answer || recursion(s,i,j,true);
                }
                return answer;
            }
        }
        return true;
    }
}