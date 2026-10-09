class Solution {
    public int minInsertions(String s) {
        int open=0;
        int insertion=0;

        int i=0;
        int n=s.length();

        while(i<n){
            char ch=s.charAt(i);

            if(ch=='(') {
                open++;
                i++;
            }
            else{
                if(i+1<n && s.charAt(i+1)==')'){
                    if(open>0){
                        open--;
                    }
                    else{
                        insertion++;
                    }
                    i+=2;
                }
                else{
                    if(open>0) {
                        open--;
                        insertion++;
                    }
                    else{
                        insertion+=2;
                    }
                    i++;
                }
            }
        }
        return insertion+2*open;
    }
}