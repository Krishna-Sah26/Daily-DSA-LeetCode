class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            // Calculate required hours
            for (int pile : piles) {
                hours += (pile + (long) mid - 1) / mid;
            }

            if (hours <= h) {
                // mid valid hai
                ans = mid;

                // Aur slow speed try karo
                high = mid - 1;

            } else {
                // mid slow hai
                low = mid + 1;
            }
        }

        return ans;
    }
}