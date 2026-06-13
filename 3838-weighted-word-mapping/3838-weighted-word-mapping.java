class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result=new StringBuilder();

        for(String word:words){
            int sum=0;
            for(char ch:word.toCharArray()){
                int index=ch-'a';
                sum+=weights[index];
            }
            sum%=26;
            char ch=(char)('a'+25-sum);
            result.append(ch);
        }
        return result.toString();
    }
}