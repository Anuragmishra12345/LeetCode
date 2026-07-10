class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;

        for(int b:bills){
            if(b==5) five++;
            else if(b==10){
                ten++;
                if(five<1) return false;
                five--;
            }
            else {
                if(ten>=1 && five>=1) {
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five-=3;
                }
                else return false;
            }
        }
        return true;
    }
}