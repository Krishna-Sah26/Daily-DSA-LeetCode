class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int suff = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            // agar prefix 0 
            if(pre==0){
                pre = 1;
            }
            if(suff==0){
                suff = 1;
            }
            // prefix product
            pre = pre*nums[i];
            // suff
            suff= suff*nums[n-i-1];

            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}