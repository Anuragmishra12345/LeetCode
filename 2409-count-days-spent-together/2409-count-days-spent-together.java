class Solution {
    int[] DaysInMonth={31,28,31,30,31,30,31,31,30,31,30,31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int AStart =daysCountingMachine(arriveAlice);
        int AEnd=daysCountingMachine(leaveAlice);

        int BStart=daysCountingMachine(arriveBob);
        int BEnd=daysCountingMachine(leaveBob);

        int start=Math.max(AStart,BStart);
        int end=Math.min(AEnd,BEnd);

        return start<=end?end-start+1:0;
        
    }

    int daysCountingMachine(String date){
        int month=Integer.parseInt(date.substring(0,2));
        int days=Integer.parseInt(date.substring(3,5));

        int totalDays=0;

        for(int i=0;i<month-1;i++){
            totalDays+=DaysInMonth[i];
        }
        return totalDays+days;
    }
}