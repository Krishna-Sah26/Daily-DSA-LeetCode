class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<high){
            int mid = low +(high-low)/2;
            if(nums[mid]>nums[high]){
               // minum is on the rigth side
               low = mid+1;
            }else if(nums[mid]<nums[high]){
                // minum is on the mid or left sdie
                high = mid;
            }else{
                /// nums [mid]== nums[high]
                // we cannot decide the side so reomve duplicate
                high --;
            }
        }
        return nums[low];
    }
}