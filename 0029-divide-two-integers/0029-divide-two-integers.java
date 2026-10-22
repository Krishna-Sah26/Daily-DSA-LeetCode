
class Solution {
    public int divide(int dividend, int divisor) {
        // Special case: both numbers are equal
        if (dividend == divisor) {
            return 1;
        }

        // Determine the sign of the result
        boolean sign = true;

        if (dividend >= 0 && divisor < 0) {
            sign = false;
        } else if (dividend < 0 && divisor > 0) {
            sign = false;
        }

        // Convert to long before taking absolute values
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        while (n >= d) {
            int cnt = 0;

            // Find the largest power of 2 by which divisor can be shifted
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            // Add the corresponding power of 2 to quotient
            quotient += (1L << cnt);

            // Subtract the shifted divisor from dividend
            n -= (d << cnt);
        }

        // Handle integer overflow
        if (quotient == (1L << 31)) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign ? (int) quotient : (int) -quotient;
    }
}
