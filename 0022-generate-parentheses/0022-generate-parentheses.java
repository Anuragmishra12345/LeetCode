class Solution {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n,0,0,"");
        return result;
    }
    void generate(int n, int open , int close, String curr){
        if(open==close && open==n) {
            result.add(curr);
            return;
        }
        if(open>n || close>n) return ;

        if(open>close){
            generate(n,open,close+1,curr+')');
        }
        generate(n,open+1,close,curr+'(');
    }
}