/*
 * @lc app=leetcode id=1480 lang=java
 *
 * [1480] Running Sum of 1d Array
 */

// @lc code=star
class Solution {
    public int[] runningSum(int[] nums) {
        int[] rSums = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            rSums[i] = i == 0 ? nums[i] : rSums[i - 1] + nums[i];
        }
        
        return rSums;
    }
}
// @lc code=end

