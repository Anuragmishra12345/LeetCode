class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.length()==0) return "Neither";
        if(queryIP.charAt(queryIP.length()-1)==':' || queryIP.charAt(queryIP.length()-1)=='.') return "Neither";
        String[] ip1=queryIP.split("[.]");
        String[] ip2=queryIP.split("[:]");
        boolean ip4=true;
        boolean ip6=true;
        int len1 =ip1.length;
        int len2 =ip2.length;
        if(len1!=4) ip4=false;
        if(len2!=8) ip6=false;

        if(!ip4 && !ip6) return "Neither";

        if(len1==4){
            for(String s:ip1){
                if(s.length()==0) {
                    ip4=false;
                    break;
                }
                if(s.length()>1 && s.charAt(0)=='0') {
                    ip4=false;
                    break;
                }
                for(char ch:s.toCharArray()){
                    if(!Character.isDigit(ch)){
                        ip4=false;
                        break;
                    }
                }
                if(!ip4) break;
                if(s.length()>3 || Integer.parseInt(s)>255 || Integer.parseInt(s)<0){
                    ip4=false;
                    break;
                }
            }
        }
        if(len2==8){
            for(String s:ip2){
                if(s.length()==0) {
                    ip6=false;
                    break;
                }
                if(s.length()>4) {
                    ip6=false;
                    break;
                }
                for(char ch:s.toCharArray()){
                    if(!Character.isDigit(ch)){
                        char c=Character.toLowerCase(ch);
                        if(c>='g' && c<='z'){
                            ip6=false;
                            break;
                        }
                    }
                }
                if(!ip6) break;
            }
        }
        if(ip4) return "IPv4";
        else if(ip6) return "IPv6";
        else return "Neither";
    }
}