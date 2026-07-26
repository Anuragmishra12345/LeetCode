class Solution {
    public int maximumProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        int firstMinimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;

        for(int num:nums){
            if(num<=firstMinimum){
                secondMinimum=firstMinimum;
                firstMinimum=num;
            }
            else if(num<secondMinimum){
                secondMinimum=num;
            }

            if(num>=first){
                third=second;
                second=first;
                first=num;
            }
            else if(num>=second){
                third=second;
                second=num;
            }
            else if(num>third){
                third=num;
            }
        }

        long p1=1L*first*second*third;
        long p2=1L*first*secondMinimum*firstMinimum;
        return (int)Math.max(p1,p2);
    }
}