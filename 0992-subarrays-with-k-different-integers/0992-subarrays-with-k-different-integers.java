class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Exactly K = (At most K) - (At most K - 1)
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    private int atMostK(int[] nums, int k) {
        if(k<=0){
            return 0;
        }
         Map<Integer, Integer> countMap = new HashMap<>();
        int l = 0;
        int count = 0;
        for(int r=0; r<nums.length; r++){
            // added the current elemnets to the map
            countMap.put(nums[r], countMap.getOrDefault(nums[r],0)+1);
            // shinrknk the windor if disnict
            while(countMap.size()>k){
                countMap.put(nums[l],countMap.get(nums[l])-1);
                if (countMap.get(nums[l]) == 0) {
                    countMap.remove(nums[l]);
                }
                l++;
            }
            count+=(r-l+1);
        }
        return count;
    }
    
}