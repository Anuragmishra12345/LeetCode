import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        // int carry=0;
        // StringBuilder sb=new StringBuilder();
        // int lena=a.length()-1;
        // int lenb=b.length()-1;
        BigInteger x=new BigInteger (a,2);
        BigInteger y=new BigInteger (b,2);
        BigInteger c=x.add(y);
        return c.toString(2);
        // while()
    }
}