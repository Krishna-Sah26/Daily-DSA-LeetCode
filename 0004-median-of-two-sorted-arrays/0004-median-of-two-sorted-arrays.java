class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Binary search hamesha chhote array par karo
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            // nums1 ka partition
            int cut1 = low + (high - low) / 2;

            // nums2 ka partition
            int cut2 = (m + n + 1) / 2 - cut1;

            // Left side ke maximum values
            int left1;
            int left2;

            if (cut1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[cut1 - 1];
            }

            if (cut2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[cut2 - 1];
            }

            // Right side ke minimum values
            int right1;
            int right2;

            if (cut1 == m) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[cut1];
            }

            if (cut2 == n) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[cut2];
            }

            // Correct partition mil gaya
            if (left1 <= right2 && left2 <= right1) {

                // Total elements odd
                if ((m + n) % 2 != 0) {
                    return Math.max(left1, left2);
                }

                // Total elements even
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            // nums1 ka partition right side zyada chala gaya
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // nums1 ka partition left side kam hai
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}