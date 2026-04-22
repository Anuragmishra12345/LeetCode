class Solution {
    public String reverseWords(String s) {
        String[] str=s.trim().split("\\s+");
        int i=0;
        int j=str.length-1;
        while(i<=j){
            String temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }
        StringBuilder result=new StringBuilder();
        for(int k=0;k<str.length;k++){
            result.append(str[k]);
            result.append(" ");
        }
        return result.toString().trim();
    }
}