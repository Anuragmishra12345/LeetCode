class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack= new Stack();
        String singleDot=".";
        String doubleDot="..";
        String[] arr=path.split("/");
        for(String str:arr){
            if(str.equals(doubleDot)){
                if(!stack.isEmpty()) stack.pop();
            }
            else if(str.equals(singleDot) || str=="") continue;
            else stack.push(str);
        } 
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
            result.insert(0,"/");
        }
        if(result.length()==0) result.append("/");
        return result.toString();
    }
}