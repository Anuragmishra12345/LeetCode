class Solution {
    public char processStr(String s, long k) {
        long L=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='*'){
                if(L>0) L--;
            }
            else if(ch=='#') L*=2;
            else if(ch=='%') continue;
            else L++;
        }
        if(k>=L) return '.';

        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);

            if(ch=='*') L++;
            else if(ch=='#') {
                L=L/2;
                if(k>=L) k-=L; 
            }
            else if(ch=='%'){
                k=L-k-1;
            }
            else L--;

            if(k==L) return ch;
        }
        return '.';
    }
}