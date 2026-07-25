class Solution {
    public int maxProduct(int n) {
        char[] arr=Integer.toString(n).toCharArray();
        Arrays.sort(arr);
        int ans=(arr[arr.length-1]-'0')*(arr[arr.length-2]-'0');
        return ans;
    }
}