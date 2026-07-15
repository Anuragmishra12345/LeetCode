class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd=1;
        int sumEven=2;
        int prevo=1;
        int preve=2;
        for(int i=1;i<n;i++){
            prevo+=2;
            preve+=2;
            sumEven+=preve;
            sumOdd+=prevo;
        }
        while(sumOdd!=0){
            int temp=sumOdd;
            sumOdd=sumEven % sumOdd;
            sumEven=temp;
        }
        return sumEven;
    }
}