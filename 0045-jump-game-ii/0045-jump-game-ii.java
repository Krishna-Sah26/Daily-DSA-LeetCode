class Solution {
    public int jump(int[] nums) {
        int start  = 0; 
        int end = 0;
        int jumps = 0;
        int maxInd = 0;
        int n = nums.length;
        while(start<n-1){
            maxInd = Math.max(maxInd, start+nums[start]);
            if(start == end){
                jumps++;
                end = maxInd;
            }
            if(end==n-1){
                return jumps;
            }
            start++;
        }
        return jumps;
    }
}