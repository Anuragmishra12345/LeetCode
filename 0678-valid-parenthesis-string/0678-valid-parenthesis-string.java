class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> open=new ArrayDeque<>();
        Deque<Integer> star=new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('){
                open.push(i);
            }
            else if(ch=='*') star.push(i);
            else {
                if(!open.isEmpty()) open.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            }
        }

        while(!open.isEmpty() && !star.isEmpty()) {
            if(open.peek()<star.peek()) {
                open.pop();
                star.pop();
            }
            else return false;
        }
        return open.isEmpty();
    }


    // public boolean checkValidString(String s) {
    //     int low=0;
    //     int high=0;

    //     for(char ch:s.toCharArray()){
    //         if(ch=='(') {
    //             low++;
    //             high++;
    //         }
    //         else if(ch==')'){
    //             low--;
    //             high--;
    //         }
    //         else {
    //             low--;
    //             high++;
    //         }

    //         if(high<0) return false;

    //         low=Math.max(0,low);
    //     }
    //     return low==0;
    // }
}