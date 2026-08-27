class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int low = 0;
        int high = cols-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            // mid column k maxamium elemnt find karo
            int maxRow = 0;
            for(int i=1;i<rows;i++){
                if(mat[i][mid]>mat[maxRow][mid]){
                    maxRow = i;
                }
            }
            int left = (mid==0)?-1:mat[maxRow][mid-1];
            int right = (mid==cols-1)?-1:mat[maxRow][mid+1];
            // current elemnt dono sa bada hai
            if(mat[maxRow][mid]>left && mat[maxRow][mid]>right){
                return new int []{maxRow,mid};
            }else if(right>mat[maxRow][mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return new int []{-1,-1};
    }
}