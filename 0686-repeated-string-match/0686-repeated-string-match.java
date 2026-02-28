class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeat=1;
        int n1=a.length();
        int n2=b.length();
        StringBuilder sa=new StringBuilder(a);
        while(sa.length()<n2){
            sa.append(a);
            repeat++;
        }
        if(isSubstring(sa.toString(),b)) return repeat;
        sa.append(a);
        repeat++;
        if(isSubstring(sa.toString(),b)) return repeat;
        return -1;
    }
    boolean isSubstring(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();

    if (m > n) return false;

    long base = 31;
    long mod = 1_000_000_007;

    long patternHash = 0;
    long windowHash = 0;
    long power = 1; // base^(m-1)

    // compute power = base^(m-1)
    for (int i = 0; i < m - 1; i++) {
        power = (power * base) % mod;
    }

    // initial hash
    for (int i = 0; i < m; i++) {
        patternHash = (patternHash * base + pattern.charAt(i)) % mod;
        windowHash = (windowHash * base + text.charAt(i)) % mod;
    }

    // slide window
    for (int i = 0; i <= n - m; i++) {

        // if hash matches → verify
        if (patternHash == windowHash) {
            if (text.substring(i, i + m).equals(pattern)) {
                return true;
            }
        }

        // roll hash
        if (i < n - m) {
            windowHash =
                (windowHash - text.charAt(i) * power % mod + mod) % mod;
            windowHash =
                (windowHash * base + text.charAt(i + m)) % mod;
        }
    }

    return false;
}
//     boolean isSubstring(String text, String pattern) {
//     if(pattern.length() == 0) return true;

//     int[] lps = buildLPS(pattern);

//     int i = 0; 
//     int j = 0; 

//     while(i < text.length()){
//         if(text.charAt(i) == pattern.charAt(j)){
//             i++;
//             j++;

//             if(j == pattern.length()) return true;
//         } 
//         else {
//             if(j != 0){
//                 j = lps[j - 1];
//             } else {
//                 i++;
//             }
//         }
//     }
//     return false;
// }
//     int[] buildLPS(String pattern){
//     int n = pattern.length();
//     int[] lps = new int[n];

//     int len = 0; 
//     int i = 1;

//     while(i < n){
//         if(pattern.charAt(i) == pattern.charAt(len)){
//             len++;
//             lps[i] = len;
//             i++;
//         } 
//         else {
//             if(len != 0){
//                 len = lps[len - 1];
//             } else {
//                 lps[i] = 0;
//                 i++;
//             }
//         }
//     }
//     return lps;
// }
}