class Solution {
    public int minAddToMakeValid(String s) {
        int moves=0;
        int open=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') {
                open++;
            }
            else{
                if(open>0) open--;
                else moves++;
            }
        }
        moves+=open;
        return moves;
    }
}