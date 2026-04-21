class Solution {
    // int i=0;
    // public String decodeString(String s) {
    //     StringBuilder result=new StringBuilder();
    //     int k=0;
    //     while(i<s.length()){
    //         char c=s.charAt(i);
    //         if(Character.isDigit(c)){
    //             k=k*10+(c-'0');
    //             i++;
    //         }
    //         else if(c=='['){
    //             i++;
    //             String inside=decodeString(s);
    //             for(int n=0;n<k;n++){
    //                 result.append(inside);
    //             }
    //             k=0;
    //         }
    //         else if(c==']'){
    //             i++;
    //             break;
    //         }
    //         else{
    //              result.append(c);
    //              i++;
    //         }     
    //     }
    //     return result.toString();
    // }
    int i=0;
    public String decodeString(String s) {
        StringBuilder result=new StringBuilder();
        int n=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch<='9' && ch>='0'){
                n=n*10+(ch-'0');
                i++;
            }
            else if(ch=='['){
                i++;
                String inside=decodeString(s);
                for(int k=0;k<n;k++){
                    result.append(inside);
                }
                n=0;
            }
            else if(ch==']'){
                i++;
                break;
            }
            else {
                result.append(ch);
                i++;
            }
        }
        return result.toString();
    }



















}