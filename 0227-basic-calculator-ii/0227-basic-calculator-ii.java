class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int result=0;
        char sign='+';
        int num=0;
        int lastNum=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9'){
                num=num*10+(ch-'0');
            }
            if((!(ch>='0' && ch<='9') && ch!=' ') || i==s.length()-1){
                if(sign=='+') {
                    result+=lastNum;
                    lastNum=num;
                }
                else if(sign=='-') {
                    result+=lastNum;
                    lastNum=num;
                }
                else if(sign=='*') {
                    lastNum*=num;
                }
                else if(sign=='/') {
                    lastNum/=num;
                }
                sign=ch;
                num=0;
            }  
        }
        return result+lastNum;
    }
}