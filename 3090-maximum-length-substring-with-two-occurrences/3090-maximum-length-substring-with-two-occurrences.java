class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();

        int left=0;
        int right=0;
        int max=0;

        while(right<s.length()){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch)>2){
                char leftChar=s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}