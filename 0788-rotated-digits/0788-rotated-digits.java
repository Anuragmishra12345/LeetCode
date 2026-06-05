class Solution {
    public int rotatedDigits(int n) {
        Set<Character> set=new HashSet<>(Set.of('2','5','6','9'));
        Set<Character> setb=new HashSet<>(Set.of('3','4','7'));
        int count=0;
        for(int i=1;i<=n;i++){
            String num=String.valueOf(i);
            boolean b=true;
            boolean c=false;
            for(int j=0;j<num.length();j++){
                if(setb.contains(num.charAt(j))){
                    b=false;
                    break;
                }
                else if(set.contains(num.charAt(j))) c=true;
            }
            if(b && c) count++;
        }
        return count;
    }
}