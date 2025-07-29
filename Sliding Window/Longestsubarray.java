
//Leetcode Problem - Longest substring without repeating characters
//Topic - Sliding window
//Level - Medium
//Approach - Use a sliding window approach with a hash set to track characters in the current window. Expand the window by moving the end pointer and contract it by moving the start pointer when a duplicate is found.

#import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
      Set<Character> seen = new HashSet<>();
      int start =0, maxLength = 0;
      for(int end =0;end<s.length();end++){
        char currentChar = s.charAt(end);
        while(seen.contains(currentChar)){
            seen.remove(s.charAt(start));
            start++;
        }
        seen.add(currentChar);
        maxLength = Math.max(maxLength,end-start +1);
      }  
      return maxLength;
    }
}