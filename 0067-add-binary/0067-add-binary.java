import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        int carry=0;
        StringBuilder sb=new StringBuilder();
        int lena=a.length()-1;
        int lenb=b.length()-1;
        
        while(lena>=0 && lenb>=0){
            int sum=carry+a.charAt(lena)-'0'+b.charAt(lenb)-'0';
            if(sum==3){
                carry=1;
                sb.insert(0,1);
            }
            else if(sum==2){
                carry=1;
                sb.insert(0,0);
            }
            else {
                carry=0;
                sb.insert(0,sum);
            }
            lena--;
            lenb--;
        }
        while(lena>=0){
            int sum=carry+a.charAt(lena)-'0';
            if(sum==2){
                carry=1;
                sb.insert(0,0);
            }
            else {
                carry=0;
                sb.insert(0,sum);
            }
            lena--;
        }
        while(lenb>=0){
            int sum=carry+b.charAt(lenb)-'0';
            if(sum==2){
                carry=1;
                sb.insert(0,0);
            }
            else {
                carry=0;
                sb.insert(0,sum);
            }
            lenb--;
        }
        if(carry==1) sb.insert(0,1);
        return sb.toString();
    }
}