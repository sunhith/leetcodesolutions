import java.util.*;
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        int j = arr.length - 1;
        while(i < j){
            if(arr[i] != arr[j]){
                char ch = (char)Math.min(arr[i], arr[j]);
                arr[i] = ch;
                arr[j] = ch;
            }
            i++;
            j--;
            
        }
        
        return String.valueOf(arr);
        
        // int n = s.length();
        // StringBuilder str = new StringBuilder(s);
        // int left = 0, right = n-1;
        // while(left < right){
        // if(s.charAt(left) != s.charAt(right)){
        //     if(s.charAt(left) > s.charAt(right)){
        //         str.setCharAt(left, s.charAt(right)); 
        //     }
        //     else{
        //         str.setCharAt(right, s.charAt(left)); 
        //     }
        // }
        //      left++;
        //      right--;
        // }
        // return str.toString();
    }
}