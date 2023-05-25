import java.util.*;
import java.lang.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
      int n = s.length();
        if(n == 1 || n==0) return n;
        boolean charVisited[] = new boolean[256];
        int i = 0, j = 1, max = 1;
        charVisited[s.charAt(0)] = true;
        while(j < n){

            if(charVisited[s.charAt(j)]){
                while( !((Character)s.charAt(i)).equals(s.charAt(j))){
                    charVisited[s.charAt(i)] = false;
                    i++;
                }
                i++;
            }

            if(j-i+1 > max){
                max = j-i+1;
            }
            charVisited[s.charAt(j)] = true;
            j++;
        }
        return max;
    }
}