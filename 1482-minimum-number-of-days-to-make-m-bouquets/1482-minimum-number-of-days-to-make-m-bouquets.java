class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        // Total flowers required
        long required = (long) m * k;

        // Flowers kam hain
        if (required > bloomDay.length) {
            return -1;
        }

        // Binary search range
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k)) {
                // mid days me bouquets ban rahe hain
                // aur minimum days try karo
                high = mid - 1;
            } else {
                // mid days enough nahi hain
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] bloomDay, int day, int m, int k) {

        int flowers = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {

                flowers++;

                // k adjacent flowers mil gaye
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }

            } else {
                // Adjacent sequence toot gayi
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}