// LeetCode Problem: Container With Most Water
// Problem Link: https://leetcode.com/problems/container-with-most-water/
// Topic - Two Pointers
// Level - Medium
// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Approach - Use two pointers, one starting from the beginning and the other from the end of the array. Calculate the area formed by the lines at these two pointers and the x-axis. Move the pointer pointing to the shorter line inward, as this will potentially increase the area.
// Time Complexity - O(n)

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxarea=0;
        for(int i=0;i<height.length;i++)
        {
            int area= Math.min(height[left],height[right])*(right-left);
            if(area>maxarea){
                maxarea=area;
            }
            if(height[left]<height[right]&& left<height.length && right>=0){
                left++;
            }else
            {
                right--;
            }
        }
        return maxarea;
    }
}