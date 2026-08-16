class Solution {
    public int searchInsert(int[] nums, int target) {

        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                // Target right side me hoga
                st = mid + 1;
            } else {
                // Target left side me hoga
                end = mid - 1;
            }
        }

        // Jahan st rukega, wahi insertion position hai
        return st;
    }
}