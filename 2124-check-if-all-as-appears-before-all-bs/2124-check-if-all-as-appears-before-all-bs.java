class Solution {
    public boolean checkString(String s) {
        boolean b=false;
        for(char ch:s.toCharArray()){
            if(b && ch=='a') return false;
            if(ch=='b') b=true;
        }
        return true;
    }
}