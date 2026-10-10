import java.util.*;

class Solution {

    // Unique set of combinations
    Set<List<Integer>> s = new HashSet<>();

    public void getCombination(
            int[] arr, int idx, int tar,
            List<List<Integer>> ans,
            List<Integer> combin) {

        // Base case
        if (idx == arr.length || tar < 0) {
            return;
        }

        if (tar == 0) {
            if (!s.contains(combin)) {
                ans.add(new ArrayList<>(combin));
                s.add(new ArrayList<>(combin));
            }
            return;
        }

        // All parameters are passed as references

        // Choice work starts here

        combin.add(arr[idx]);

        // Single pick
        getCombination(arr, idx + 1, tar - arr[idx], ans, combin);

        // Multiple pick
        getCombination(arr, idx, tar - arr[idx], ans, combin);

        // Remove the last element (backtracking)
        combin.remove(combin.size() - 1);

        // Exclusion choice
        getCombination(arr, idx + 1, tar, ans, combin);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();

        s.clear();

        getCombination(candidates, 0, target, ans, combin);

        return ans;
    }
}