class Solution {
    public String processStr(String s) {
        StringBuilder result=new StringBuilder();

        for(char ch:s.toCharArray()){
            if(ch=='#'){
                result.append(result);
            }
            else if(ch=='%'){
                result.reverse();
            }
            else if(ch=='*'){
                if(!result.isEmpty()) result.deleteCharAt(result.length()-1);
            }
            else result.append(ch);
        }
        return result.toString();
    }
}