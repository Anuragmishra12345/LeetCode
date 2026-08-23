class Solution {
    public boolean sumGame(String s) {

        int n=s.length();
        int leftSum=0;
        int rightSum=0;

        int leftQ=0;
        int rightQ=0;

        for(int i=0;i<n/2;i++){
            if(s.charAt(i)=='?') leftQ++;
            else leftSum+=s.charAt(i)-'0';
        }
        for(int i=n/2;i<n;i++){
            if(s.charAt(i)=='?') rightQ++;
            else rightSum+=s.charAt(i)-'0';
        }
        return 2*(leftSum-rightSum)+9*(leftQ-rightQ)!=0;
    }
}