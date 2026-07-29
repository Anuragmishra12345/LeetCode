class Solution {
    public int addDigits(int num) {
        while(num>=10){
            int currNum=0;
            while(num>0){
                currNum+=num%10;
                num/=10;
            }
            num=currNum;
        }
        return num;
    }
}