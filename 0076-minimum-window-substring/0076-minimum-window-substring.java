class Solution {
    public String minWindow(String s, String t) {
        StringBuilder result=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        int left=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            temp.append(ch);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)-1);
            while(empty(map)){
                if (result.length() == 0 || temp.length() < result.length()) {
                    result.replace(0, result.length(), temp.toString());
                }
                temp.deleteCharAt(0);
                if(map.containsKey(s.charAt(left))) map.put(s.charAt(left),map.get(s.charAt(left))+1);
                left++;
            }
        }
        return result.toString();
    }
    boolean empty(Map<Character,Integer> map){
        for(Integer value:map.values()){
            if(value>0) return false;
        }
        return true;
    }
}