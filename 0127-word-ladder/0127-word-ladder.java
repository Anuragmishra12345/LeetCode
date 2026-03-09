class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int step=1;

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(endWord)) return step;

                char[] arr=s.toCharArray();

                for(int j=0;j<arr.length;j++){
                    char original=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        arr[j]=ch;
                        String temp=new String(arr);
                        if(set.contains(temp)){
                            set.remove(temp);
                            q.add(temp);
                        }
                    }
                    arr[j]=original;
                }
            }
            step++;
        }
        return 0;
    }
}