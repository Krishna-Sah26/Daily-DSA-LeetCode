class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // low = maximum package weight
        // high = total weight
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(weights, mid, days)) {

                // Capacity valid hai
                // aur chhoti capacity try karo
                high = mid - 1;

            } else {

                // Capacity chhoti hai
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] weights, int capacity, int days) {

        int daycount = 1;
        int currentweight = 0;

        for (int weight : weights) {

            if (currentweight + weight <= capacity) {

                currentweight += weight;

            } else {

                // New day
                daycount++;
                currentweight = weight;
            }
        }

        return daycount <= days;
    }
}