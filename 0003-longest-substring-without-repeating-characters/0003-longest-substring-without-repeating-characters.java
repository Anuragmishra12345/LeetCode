class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int left = 0;
        // int maxLen = 0;
        // int[] freq = new int[128];

        // for (int right = 0; right < s.length(); right++) {
        //     char c = s.charAt(right);
        //     freq[c]++;

        //     while (freq[c] > 1) {
        //         freq[s.charAt(left)]--;
        //         left++;
        //     }
        //     maxLen = Math.max(maxLen, right - left + 1);
        // }
        // return maxLen;
        int left=0;
        int len=0;
        Set<Character> set=new HashSet<>();
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            len=Math.max(len,right-left+1);
        }
        return len;
    }
}