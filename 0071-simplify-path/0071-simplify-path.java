class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] arr=path.split("/");
        for(String str:arr){
            if(str.equals("..")){
                if(!stack.isEmpty()) stack.removeLast();
            }
            else if(str.equals(".") || str.equals("")) continue;
            else stack.addLast(str);
        } 
        if(stack.isEmpty()) return "/";

        StringBuilder result=new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        return result.toString();
    }
}