class Solution {
    public String[] createGrid(int m, int n) {
        String[] result=new String[m];
        StringBuilder first=new StringBuilder();
        for(int i=0;i<n;i++) first.append('.');

        result[0]=first.toString();

        for(int i=1;i<m;i++){
            StringBuilder next=new StringBuilder();
            for(int j=0;j<n-1;j++) next.append('#');
            next.append('.');
            result[i]=next.toString();
        }

        return result;
    }
}