class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> anagram=new HashMap<>();

        for(String s:strs){
            char[] st=s.toCharArray();
            Arrays.sort(st);
            String key=new String(st);
            anagram.computeIfAbsent(key,k->new ArrayList<>());
            anagram.get(key).add(s);
        }

        List<List<String>> result=new ArrayList<>();
        result.addAll(anagram.values());
        return result;
    }
}