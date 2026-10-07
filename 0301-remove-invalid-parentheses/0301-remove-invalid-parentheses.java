class Solution {
    List<String> result=new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int invalid=0;
        int status=0;
        for(char ch:s.toCharArray()){
            if(ch!='(' && ch!=')') continue;
            if(ch=='(') status++;
            else{
                if(status<=0){
                    invalid++;
                }
                else{
                    status--;
                }
            }
        }
        invalid+=status;

        dfs(s,0,"",invalid);

        return result;
    }
    boolean isValid(String s){
        int invalid=0;
        int status=0;
        for(char ch:s.toCharArray()){
            if(ch!='(' && ch!=')') continue;
            if(ch=='(') status++;
            else{
                if(status<=0){
                    invalid++;
                }
                else{
                    status--;
                }
            }
        }
        invalid+=status;

        return invalid==0;
    }

    void dfs(String s, int index, String curr, int invalid){
        if(index==s.length()){
            if(isValid(curr) && !result.contains(curr)) result.add(curr);
            return;
        }

        dfs(s,index+1,curr+s.charAt(index),invalid);

        if(invalid>0 && (s.charAt(index)=='(' || s.charAt(index)==')')) dfs(s,index+1,curr,invalid-1);
    }
}