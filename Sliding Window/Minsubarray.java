// LeetCode Problem: Minimum Size Subarray Sum
// Topic - Sliding window
//Level - medium
//use sliding window approach where we inpt an unsorted array and a target element find the smallest substring whose sum is equal or grater to the target element and output the number of elements required to satisfy this condition
//approach
//poit start and end to the first element and keep on increasig the value of end unil the sum of elements from start to end are greater or equal to target. if the condition becomes true then start to add the elements in min length variable and keep on increasing start ow until te sum is less than the taget 






class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
