class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result=new StringBuilder();

        while(columnNumber>0){
            int num=--columnNumber;
            num=num%26;
            result.insert(0,(char)(num+'A'));
            columnNumber/=26;
        }
        return result.toString();
    }
}