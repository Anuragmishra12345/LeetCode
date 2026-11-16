class Solution {
    public String digitSum(String s, int k) {
        StringBuilder result=new StringBuilder();

        int length=s.length();

        while(length>k){
            int i=0;
            while(i<length){
                int size=k;
                long sum=0;
                while(i<length && size>0){
                    sum+=s.charAt(i)-'0';
                    i++;
                    size--;
                }
                result.append(sum);
            }
            s=result.toString();
            length=s.length();
            result.setLength(0);
        }
        return s;
    }
}