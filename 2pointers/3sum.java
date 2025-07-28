// LeetCode Problem: 15. 3Sum
// Problem Link: https://leetcode.com/problems/3sum/    
// Topic - Two Pointers
// Level - Medium
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Note: The solution set must not contain duplicate triplets.
// Approach - Sort the array first. Then use a loop to fix one element and use two pointers to find pairs that sum to the negative of the fixed element. Skip duplicates to avoid repeated triplets.
// Time Complexity - O(n^2)
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  

        for (int i = 0; i < nums.length - 2; i++) {
        
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

            
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  
                } else {
                    right--; 
                }
            }
        }

        return result;
    }
}
