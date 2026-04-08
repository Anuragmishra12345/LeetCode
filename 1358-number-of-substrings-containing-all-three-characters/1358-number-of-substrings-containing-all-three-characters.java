class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int count=0;
        int[] arr=new int[3];
        for(int right=0;right<s.length();right++){
            arr[s.charAt(right)-'a']++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                count+=s.length()-right;
                arr[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return count;
    }
}