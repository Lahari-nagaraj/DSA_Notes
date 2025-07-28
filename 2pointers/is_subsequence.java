// LeetCode Problem: Is Subsequence
// Problem Link: https://leetcode.com/problems/is-subsequence/
// Topic - Two Pointers
// Level - Easy
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
// Approach - Use two pointers, one for each string. Traverse through the second string and check if characters in the first string match in order.
// Time Complexity - O(n)


class Solution {
    public boolean isSubsequence(String s, String t) {
        int count =0;
         if (s.length() == 0) return true;//extra condition if the first string is empty, it is a subsequence of any string
       
        for(int i=0;i<t.length();i++){
         char ch1 = s.charAt(count);
char ch2 = t.charAt(i);

        if(ch1==ch2){
            count++;
        }
        if(count== s.length()){// if count equals the length of s, it means all characters of s have been found in t in order(indexoutof bound exception occurs without this condition e.g take s="b" and t some string of 3 letters now b is present and count++ has no value hence error)
            {
            return true;
        }
    }
        }
        if(count<s.length()){
            return false;
        }
   return true;
        }
     

    }
