class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            int num=columnNumber%26;
            columnNumber/=26;
            char ch=(char)('A'+num);
            sb.insert(0,ch);
        }
        return sb.toString();
    }
}