// class Solution {
//     List<List<String>> result = new ArrayList<>();
//     Map<String, Integer> map=new HashMap<>();
//     String b;
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         Set<String> set = new HashSet<>(wordList);
//         Queue<String> q=new LinkedList<>();
//         b=beginWord;
//         if(!set.contains(endWord)) return result;
//         map.put(beginWord,1);
//         q.add(beginWord);
//         int size=beginWord.length();

//         while(!q.isEmpty()){
//             String word=q.poll();
//             int step=map.get(word);

//             for(int i=0;i<size;i++){
//                 for(char ch='a';ch<='z';ch++){
//                     char[] wa=word.toCharArray();
//                     wa[i]=ch;
//                     String newWord=new String(wa);
//                     if(set.contains(newWord)){
//                         map.put(newWord,step+1);
//                         set.remove(newWord);
//                         q.add(newWord);
//                     }
//                 }
//             }
//         }
//         if(map.containsKey(endWord)){
//             List<String> seq= new ArrayList<>();
//             seq.add(endWord);
//             dfs(endWord,seq);
//         }
//         return result;
//     }

//     void dfs(String word,List<String> seq ){

//         if(word.equals(b)){
//             List<String> f=new ArrayList<>(seq);
//             Collections.reverse(f);
//             result.add(f);
//             return;
//         }
//         int step=map.get(word);
//         int size=word.length();

//         for(int i=0;i<size;i++){
//             for(char ch='a';ch<='z';ch++){
//                 char[] wa=word.toCharArray();
//                 wa[i]=ch;
//                 String newWord=new String(wa);
//                 if(map.containsKey(newWord) && map.get(newWord)+1==step){
//                     seq.add(newWord);
//                     dfs(newWord,seq);
//                     seq.remove(seq.size()-1);
//                 }
//             }
//         }
//     }
// }

class Solution {
    List<List<String>> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    String b;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        b = beginWord;

        if (!set.contains(endWord)) return result;

        map.put(beginWord, 1);
        q.add(beginWord);

        int size = beginWord.length();

        // 🔥 BFS with level control
        while (!q.isEmpty()) {

            int sz = q.size();
            Set<String> used = new HashSet<>();

            for (int k = 0; k < sz; k++) {
                String word = q.poll();
                int step = map.get(word);

                for (int i = 0; i < size; i++) {
                    char[] wa = word.toCharArray(); // moved here

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == word.charAt(i)) continue;

                        wa[i] = ch;
                        String newWord = new String(wa);

                        if (set.contains(newWord)) {
                            if (!map.containsKey(newWord)) {
                                map.put(newWord, step + 1);
                                q.add(newWord);
                                used.add(newWord);
                            }
                        }
                    }
                }
            }

            // 🔥 remove AFTER level
            for (String w : used) set.remove(w);
        }

        // DFS
        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return result;
    }

    void dfs(String word, List<String> seq) {

        if (word.equals(b)) {
            List<String> f = new ArrayList<>(seq);
            Collections.reverse(f);
            result.add(f);
            return;
        }

        int step = map.get(word);
        int size = word.length();

        for (int i = 0; i < size; i++) {
            char[] wa = word.toCharArray();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) continue;

                wa[i] = ch;
                String newWord = new String(wa);

                // 🔥 correct condition
                if (map.containsKey(newWord) && map.get(newWord) == step - 1) {
                    seq.add(newWord);
                    dfs(newWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
}