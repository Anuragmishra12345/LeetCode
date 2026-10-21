class Solution {
    public int minOperations(String s) {
        boolean isSorted=true;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)>s.charAt(i+1)){
                isSorted=false;
                break;
            }
        }
        if(isSorted) return 0;

        if(s.length()==2) return -1;

        int[] arr=new int[26];

        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }

        int start=0;
        int end=25;

        while(arr[start]==0) start++;
        while(arr[end]==0) end--;

        if(s.charAt(0)==('a'+start) || s.charAt(s.length()-1)==('a'+end)) return 1;

        if(s.charAt(0)==('a'+end) && arr[end]==1 && s.charAt(s.length()-1)==('a'+start) && arr[start]==1) return 3;

        return 2;

    }
}