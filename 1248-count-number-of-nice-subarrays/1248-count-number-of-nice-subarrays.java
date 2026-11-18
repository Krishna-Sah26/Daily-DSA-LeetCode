class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        return most(nums,goal)-most(nums,goal-1);
    }
    public int most(int[]nums,int goal){
        if(goal<0){
            return 0;
        }
        int l=0;
        int sum=0;
        int count = 0;
        for(int r=0; r<nums.length; r++){
            sum+=(nums[r] %2);
            while(sum>goal){
                sum-=(nums[l] %2);
                l++;
            }
           count += (r - l + 1);
        }
        return count;

    }
}