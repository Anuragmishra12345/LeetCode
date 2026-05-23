class Solution {
    public int minimumDeletions(String s) {
        int delete=0;
        int count=0;

        for(char ch:s.toCharArray()){
            if(ch=='b') count++;
            else {
                delete=Math.min(count,delete+1);
            }
        }
        return delete;
    }
}