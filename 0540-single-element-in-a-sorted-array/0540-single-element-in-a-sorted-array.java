class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int st = 0;
        int end = n - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            // First element
            if (mid == 0 && nums[0] != nums[1]) {
                return nums[mid];
            }

            // Last element
            if (mid == n - 1 && nums[n - 1] != nums[n - 2]) {
                return nums[mid];
            }

            // Unique element
            if (nums[mid - 1] != nums[mid] &&
                nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // mid is even
            if (mid % 2 == 0) {

                if (nums[mid - 1] == nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }

            } 
            // mid is odd
            else {

                if (nums[mid - 1] == nums[mid]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}