class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int low = 1;
        int high = x;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            // kya mid kan ans n sa choota heya equal hai 
            if(mid<=x/mid){
                ans = mid;
                // tho right side jawo
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}