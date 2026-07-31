class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;
        while(mid<=high){
            // heya case hai 0 ka liya
            if(nums[mid]==0){
               int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                 mid++;
                low++;
            }
            // heya case 1 ka liya hai
            else if(nums[mid]==1){
                mid++;
            }
            else{
                 int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }

        }
    }
}