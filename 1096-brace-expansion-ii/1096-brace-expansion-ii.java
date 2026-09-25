class Solution {
    int i=0;
    public List<String> braceExpansionII(String expression) {
        List<String> result=new ArrayList<>(parseExpression(expression));
        Collections.sort(result);
        return result;
    }
    Set<String> parseExpression(String s){
        Set<String> result=parseTerm(s);

        while(i<s.length() && s.charAt(i)==','){
            i++;
            Set<String> next=parseTerm(s);
            result.addAll(next);
        }
        return result;
    }
    
    Set<String> parseTerm(String s){
        Set<String> result=new HashSet<>();
        result.add("");

        while(i<s.length() && s.charAt(i)!=',' && s.charAt(i)!='}'){
            Set<String> next=parseFactor(s);

            result=combine(result,next);
        }
        return result;
    }

    Set<String> parseFactor(String s){
        Set<String> result=new HashSet<>();

        if(s.charAt(i)!='{'){
            result.add(String.valueOf(s.charAt(i)));
            i++;
            return result;
        }

        i++;
        result=parseExpression(s);

        i++;
        return result;
    }

    Set<String> combine(Set<String> a, Set<String> b){
        Set<String> result=new HashSet<>();

        for(String x:a){
            for(String y:b){
                result.add(x+y);
            }
        }
        return result;
    }
}