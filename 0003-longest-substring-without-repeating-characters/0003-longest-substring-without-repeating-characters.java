class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int left=0;
        int maxLen=1;
        int[] arr=new int[128];
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);

            arr[ch]++;

            while(arr[ch]>1){
                char chLeft=s.charAt(left);
                arr[chLeft]--;
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}