import java.util.*;
class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        int left = 0, right = n-1;
        while(left < right){
        if(s.charAt(left) != s.charAt(right)){
            if(s.charAt(left) > s.charAt(right)){
                str.setCharAt(left, s.charAt(right)); 
            }
            else{
                str.setCharAt(right, s.charAt(left)); 
            }
        }
             left++;
             right--;
        }
        return str.toString();
    }
}