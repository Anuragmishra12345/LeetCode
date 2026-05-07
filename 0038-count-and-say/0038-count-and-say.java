class Solution {
    public String countAndSay(int n) {
        
        StringBuilder sb=new StringBuilder();

        sb.append('1');
        int i=1;
        while(i<n){
            StringBuilder curr=new StringBuilder();
            int count=1;
            for(int right=0;right<sb.length()-1;right++){
                if(sb.charAt(right)==sb.charAt(right+1)) count++;
                else { 
                    curr.append(count);
                    curr.append(sb.charAt(right));
                    count=1;
                }
            }
            curr.append(count);
            curr.append(sb.charAt(sb.length()-1));
            sb=curr;
            i++;
        }
        return sb.toString();
    }
}