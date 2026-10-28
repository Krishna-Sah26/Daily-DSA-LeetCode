class Solution {
    public int[] buildArray(int[] nums) {
        // phele ham store karenga
        int [] ans = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}