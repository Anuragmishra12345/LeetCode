class Solution {
    public int romanToInt(String s) {
        int answer=0;
        int i=0;
        while(i<s.length()-1){
            char ch=s.charAt(i);
            char chnext=s.charAt(i+1);
            if(ch=='I' && (chnext=='V' || chnext=='X')){
                i++;
                if(ch=='I' && chnext=='V') answer+=4;
                if(ch=='I' && chnext=='X') answer+=9;
            }
            else if(ch=='X' && (chnext=='L' || chnext=='C')){
                i++;
                if(ch=='X' && chnext=='L') answer+=40;
                if(ch=='X' && chnext=='C') answer+=90;
            }
            else if(ch=='C' && (chnext=='D' || chnext=='M')){
                i++;
                if(ch=='C' && chnext=='D') answer+=400;
                if(ch=='C' &&  chnext=='M') answer+=900;
            }
            else {
                if(ch=='I') answer+=1;
                else if(ch=='V') answer+=5;
                else if(ch=='X') answer+=10;
                else if(ch=='L') answer+=50;
                else if(ch=='C') answer+=100;
                else if(ch=='D') answer+=500;
                else answer+=1000;
            }
            i++;
        }
        if(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='I') answer+=1;
            else if(ch=='V') answer+=5;
            else if(ch=='X') answer+=10;
            else if(ch=='L') answer+=50;
            else if(ch=='C') answer+=100;
            else if(ch=='D') answer+=500;
            else answer+=1000;
        }
        return answer;
    }
}