class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        int count = 0;

        // Left part
        count += mergeSort(nums, low, mid);

        // Right part
        count += mergeSort(nums, mid + 1, high);

        // Count reverse pairs
        count += countPairs(nums, low, mid, high);

        // Merge both sorted parts
        merge(nums, low, mid, high);

        return count;
    }

    public int countPairs(int[] nums, int low, int mid, int high) {

        int count = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (j <= high && (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        return count;
    }

    public void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // Copy temp back
        for (int x = 0; x < temp.length; x++) {
            nums[low + x] = temp[x];
        }
    }
}