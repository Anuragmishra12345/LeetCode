class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<groupSizes.length;i++){
            int group=groupSizes[i];
            if(map.containsKey(group)){
                List<Integer> list=map.get(group);
                list.add(i);
                map.put(group,list);
            }
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(group, list);
            }
        }

        List<List<Integer>> result=new ArrayList<>();

        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            int group=entry.getKey();
            List<Integer> list=entry.getValue();
            int groups=list.size()/group;

            int index=0;

            for(int i=0;i<groups;i++){
                List<Integer> ans=new ArrayList<>();
                for(int j=0;j<group;j++){
                    ans.add(list.get(index++));
                }
                result.add(ans);
            }
        }
        return result;
    }
}