class Solution {
    public int nextGreaterElement(int n) {
        StringBuilder num=new StringBuilder(String.valueOf(n));

        int first=-1;
        int second=-1;

        for(int i=1;i<num.length();i++){
            if(num.charAt(i)>num.charAt(i-1)){
                first=i-1;
            }
        }
        if(first==-1) return -1;
        for(int i=first+1;i<num.length();i++){
            if(num.charAt(i)>num.charAt(first)){
                second=i;
            }
        }

        if(first==-1 && second==-1) return -1;
        char temp=num.charAt(first);
        num.setCharAt(first, num.charAt(second));
        num.setCharAt(second,temp);

        int i=first+1;
        int j=num.length()-1;
        while(i<j){
            char t=num.charAt(i);
            num.setCharAt(i,num.charAt(j));
            num.setCharAt(j,t);
            i++;
            j--;
        }
        long result=Long.parseLong(num.toString());
        return (result>Integer.MAX_VALUE)?-1:(int)result;
    }
}