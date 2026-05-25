class Solution {
    public int maxProduct(String[] words) {
        int len =0;
        int[] mask=new int[words.length];
        for(int i=0;i<words.length;i++){
            for(char ch:words[i].toCharArray()){
                mask[i] |=(1<<(ch-'a'));
            }
        }
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i] & mask[j])==0){
                    len=Math.max(len,words[i].length()*words[j].length());
                }
            }
        }
        return len;
    }
}