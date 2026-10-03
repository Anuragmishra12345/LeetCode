class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int letterFreq=0;
        int inLetter=0;
        StringBuilder result=new StringBuilder();

        for(char ch:s.toCharArray()) if(ch==letter) letterFreq++;

        Deque<Character> stack=new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==letter) letterFreq--;

            while(!stack.isEmpty() && stack.peek()>ch && stack.size()-1+s.length()-i>=k){
                
                if(stack.peek()==letter){
                    if(inLetter-1+letterFreq>=repetition){
                        inLetter--;
                        stack.pop();
                    }
                    else break;
                }
                else {
                    stack.pop();
                }
            }

            if(stack.size()<k){
                if(ch==letter) {
                    stack.push(ch);
                    inLetter++;
                }
                else{
                    int required=repetition-inLetter;
                    int remainingSlots=k-stack.size()-1;

                    if(remainingSlots>=required) stack.push(ch);
                }
            }
        }

        while(!stack.isEmpty()){
            result.append(stack.removeLast());
        }
        return result.toString();
    }

}