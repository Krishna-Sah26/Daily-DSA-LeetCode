import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        // Fix the first element
        for (int i = 0; i < n; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Two pointers
            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                // Sum is too small
                if (sum < 0) {
                    j++;
                }

                // Sum is too large
                else if (sum > 0) {
                    k--;
                }

                // Sum is exactly 0
                else {
                    ans.add(Arrays.asList(
                        nums[i],
                        nums[j],
                        nums[k]
                    ));

                    j++;
                    k--;

                    // Skip duplicate j values
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // Skip duplicate k values
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return ans;
    }
}