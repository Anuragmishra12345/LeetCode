class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteDegree=minutes*6;
        double hourDegree=0;
        if(hour!=12) hourDegree=hour*5*6;
        hourDegree+=(minutes*5*6)/60.0;
        double angle=Math.abs(hourDegree-minuteDegree);
        angle=Math.min(angle,360-angle);
        return angle;
    }
}