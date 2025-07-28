//problem link: https://leetcode.com/problems/valid-palindrome/
// Topic - 2pointers
// Level - easy
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring special characters and spaces.
// Approach - use two pointers, one from start and one from end, check if characters are equal, if not return false, else move both pointers towards center
// Time complexity - O(n)   

class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i=0;i<s.length();i++){
            
            char ch= s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                str += Character.toLowerCase(ch);
            }
        }
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
                i++;
                j--;
            }
        
        
        return true;

    }
}