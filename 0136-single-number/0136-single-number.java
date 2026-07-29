class Solution {
    public int singleNumber(int[] nums) {
        int store = 0;
        for(int i=0;i<nums.length;i++){
            store = store^nums[i];
        }
         return store;
    }
   
}