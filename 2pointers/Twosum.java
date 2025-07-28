// LeetCode Problem: Two Sum II - Input array is sorted
// Problem Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Topic - Two Pointers
// Level - Easy
// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
// Return the indices of the two numbers, indexed from 1, in ascending order.
// Approach - Use two pointers, one starting from the beginning and the other from the end of the array. If the sum of the two numbers is equal to the target, return their indices. If the sum is less than the target, move the left pointer to the right; if greater, move the right pointer to the left.
// Time Complexity - O(n)


//using 2 loops with time complexity n^2
/* 
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] resultList = new int[2];
        int count =0;
        while(count<numbers.length-1){
        int ptr1 = numbers[count];
        for(int i=count+1;i<numbers.length;i++){
            int ptr2 = numbers[i];
            if(ptr1+ptr2 == target){
                resultList[0]=count+1;
                resultList[1]=i+1;
                return resultList;
            }
        }
        count++;
        }
        return resultList;
    }
}
*/

//optimized solution using two pointers
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1}; // 1-based indexing
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {}; // If no pair is found
    }
}

