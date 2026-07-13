class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        boolean[] visited=new boolean[26];
        int[] freq=new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch:s.toCharArray()){
            if(visited[ch-'a']){
                freq[ch-'a']--;
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>ch && freq[stack.peek()-'a']>=1){
                visited[stack.pop()-'a']=false;
            }
            stack.push(ch);
            freq[ch-'a']--;
            visited[ch-'a']=true;
        }
        StringBuilder result=new StringBuilder();
        for(char ch:stack) result.insert(0,stack.pop());
        return result.toString();
    }
}