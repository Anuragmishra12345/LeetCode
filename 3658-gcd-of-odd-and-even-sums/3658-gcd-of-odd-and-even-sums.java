class Solution {
    public int gcdOfOddEvenSums(int n) {
        // return n;

        int sumOdd=n*n;
        int sumEven=(1+n)*n;
        while(sumOdd!=0){
            int temp=sumOdd;
            sumOdd=sumEven % sumOdd;
            sumEven=temp;
        }
        return sumEven;
        
    }
}