class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();
        for(List<String> k:knowledge){
            String key=k.get(0);
            String value=k.get(1);
            map.put(key,value);
        }

        StringBuilder result=new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)!='('){
                result.append(s.charAt(i));
                i++;
            }
            else{
                i++;
                int j=i;
                while(s.charAt(j)!=')'){
                    j++;
                }
                if(j==i) continue;
                String key=s.substring(i,j);
                if(map.containsKey(key)){
                    result.append(map.get(key));
                }
                else{
                    result.append("?");
                }
                i=j+1;
            }
        }
        return result.toString();
    }
}