import java.util.*;
import java.lang.*;
class Solution {
    // Sliding window technique
    public int lengthOfLongestSubstring(String s) {
      int n = s.length();
        if(n == 1 || n==0) return n;
        boolean charVisited[] = new boolean[256];
        int i = 0, j = 1, max = 1; // i-> left pntr; j-> right pntr
        charVisited[s.charAt(0)] = true;
        
        while(j < n){
            // if character is repeated
            if(charVisited[s.charAt(j)]){
                // move left ptr till left and right ptr chars are equal and also mark char at ith position as unvisited
                while( !((Character)s.charAt(i)).equals(s.charAt(j))){
                    charVisited[s.charAt(i)] = false;
                    i++;
                }
                // move the left pntr by 1 since left and right ptr chars are equal
                i++;
            }

            //if new substring length is greater than max
            if(j-i+1 > max){
                max = j-i+1;
                // for printing substring
                // startIndex = i
                // endIndex = j
            }
            charVisited[s.charAt(j)] = true;
            j++;
        }
        return max;
    }
}