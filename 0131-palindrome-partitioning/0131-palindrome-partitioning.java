class Solution {

    // Check whether a string is palindrome
    public boolean isPalin(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Recursive function
    public void getallparts(
        String s,
        List<String> partitions,
        List<List<String>> ans
    ) {

        // Base case
        if (s.length() == 0) {
            ans.add(new ArrayList<>(partitions));
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            // Take substring from index 0 to i
            String part = s.substring(0, i + 1);

            if (isPalin(part)) {

                // Choose
                partitions.add(part);

                // Explore remaining string
                getallparts(s.substring(i + 1), partitions, ans);

                // Backtracking: undo choice
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> partitions = new ArrayList<>();

        getallparts(s, partitions, ans);

        return ans;
    }
}