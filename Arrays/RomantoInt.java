
// problem - (13)https://leetcode.com/problems/roman-to-integer/
// Topic - strings
// Level - easy
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M convert the into integer value(by summing) 
//Approach - start from last index, if the current value is less than the previous value, subtract it from total else add it to total(XC = 90, so 100 - 10 = 90)
// Time complexity - O(n)

class Solution {
    public int romanToInt(String s) {
        int total=0;
        int prev=0;
        for(int i=s.length() -1;i>=0;i--){
            int curr = value(s.charAt(i));
            if(curr < prev){
                total -= curr;
            }else{
                total+= curr;
            }
            prev = curr;
        }
        return total;
    }
    private int value(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}