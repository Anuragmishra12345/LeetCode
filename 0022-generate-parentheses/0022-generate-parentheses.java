class Solution {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("",n,n);
        return result;
    }
    public void generate(String curr, int open , int close){
        if(open==0 && close==0){
            result.add(curr);
            return;
        }
        if(open>0){
            generate(curr+'(',open-1,close);
        }
        if(close>open){
            generate(curr+')',open,close-1);
        }  
    }
}