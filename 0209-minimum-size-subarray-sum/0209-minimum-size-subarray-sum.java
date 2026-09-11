class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Right se element window mein add karo
            sum += nums[right];

            // Jab sum target se >= ho jaye
            while (sum >= target) {

                // Current window ki length check karo
                minLength = Math.min(minLength, right - left + 1);

                // Left wala element remove karo
                sum -= nums[left];

                // Left ko aage badhao
                left++;
            }
        }

        // Agar koi valid subarray nahi mila
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }
}