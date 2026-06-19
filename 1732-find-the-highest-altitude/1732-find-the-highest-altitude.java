class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude=0;
        int prefixSum=0;
        for(int n:gain){
            prefixSum+=n;
            maxAltitude=Math.max(prefixSum,maxAltitude);
        }
        return maxAltitude;
    }
}