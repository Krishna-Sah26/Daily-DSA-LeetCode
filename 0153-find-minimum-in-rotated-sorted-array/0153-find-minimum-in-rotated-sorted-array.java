class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum right side me hai
                low = mid + 1;
            } else {
                // Minimum mid ya left side me ho sakta hai
                high = mid;
            }
        }

        return nums[low];
    }
}