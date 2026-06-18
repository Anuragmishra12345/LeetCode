class Solution {
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String,Integer>> stack=new Stack<>();
        stack.push(new TreeMap<>());
        int i=0;
        int n=formula.length();

        while(i<n){
            char ch=formula.charAt(i);
            if(ch=='('){
                stack.push(new TreeMap<>());
                i++;
            }
            else if(ch==')'){
                i++;
                int multiplier=0;
                while(i<n && Character.isDigit(formula.charAt(i))){
                    multiplier=multiplier*10+formula.charAt(i)-'0';
                    i++;
                }
                if(multiplier==0) multiplier=1;

                TreeMap<String,Integer> curr=stack.pop();
                TreeMap<String,Integer> parent=stack.peek();

                for(Map.Entry<String,Integer> entry:curr.entrySet()){
                    String atom=entry.getKey();
                    int count=entry.getValue()*multiplier;

                    parent.put(atom,parent.getOrDefault(atom,0)+count);
                }
            }
            else {
                StringBuilder atom=new StringBuilder();

                atom.append(ch);
                i++;

                while(i<n && Character.isLowerCase(formula.charAt(i))){
                    atom.append(formula.charAt(i));
                    i++;
                }

                int count=0;

                while(i<n && Character.isDigit(formula.charAt(i))){
                    count=count*10+formula.charAt(i)-'0';
                    i++;
                }
                if(count==0) count=1;

                TreeMap<String,Integer> map=stack.peek();

                map.put(atom.toString(),map.getOrDefault(atom.toString(),0)+count);
            }
        }
        StringBuilder result=new StringBuilder();

        TreeMap<String,Integer> map=stack.pop();

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            result.append(entry.getKey());
            int count=entry.getValue();
            if(count!=1) result.append(count);
        } 
        return result.toString();
    }
}