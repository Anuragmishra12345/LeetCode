class Solution {
    public String smallestSubsequence(String s) {
        boolean[] visited=new boolean[26];
        int[] freq=new int[26];

        for(char ch:s.toCharArray()) freq[ch-'a']++;
        Deque<Character> stack=new ArrayDeque<>();

        for(char ch:s.toCharArray()){
            if(visited[ch-'a']) {
                freq[ch-'a']--;
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>ch && freq[stack.peek()-'a']>0){
                visited[stack.peek()-'a']=false;
                stack.pop();
            }
            stack.push(ch);
            freq[ch-'a']--;
            visited[ch-'a']=true;
        }
        StringBuilder result=new StringBuilder();
        for(char ch:stack){
            result.insert(0,ch);
        }
        return result.toString();
    }
}