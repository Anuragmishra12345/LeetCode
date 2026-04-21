class Solution {
    int i=0;

    public int calculate(String s) {
        int result=0;
        int num=0;
        char sign='+';
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch==' '){
                i++;
                continue;
            }
            if(ch<='9' && ch>='0'){
                num=num*10+(ch-'0');
                i++;
            }
            else if (ch == '+' || ch == '-') {
                if (sign == '+') result += num;
                else result -= num;

                sign = ch;
                num = 0;
                i++;
            } 
            else if(ch=='('){
                i++;
                int val=calculate(s);
                if(sign=='+') result+=val;
                else result-=val;
            }
            else if(ch==')'){
                i++;
                break;
            }
        }
        if (sign == '+') result += num;
        else result -= num;
        return result;
    }
}