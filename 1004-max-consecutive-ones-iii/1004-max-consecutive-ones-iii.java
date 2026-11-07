class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxlength = 0;
        int left = 0;
        int zeros = 0;
        
        // 1. The outer loop moves the right pointer to expand the window
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            
            // 2. If zeros exceed k, shrink the window from the left
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++; // Always advance left to avoid an infinite loop
            }
            
            // 3. Update the maximum length at each valid step
            int length = right - left + 1;
            maxlength = Math.max(maxlength, length);
        }
        
        return maxlength;
    }
}
