class Solution {
    public List<List<Integer>> generate(int numRows) {
        // to store the result of aaray
        List<List<Integer>> ans = new ArrayList<>();
        // generet all row
        for(int i=0;i<numRows;i++){
            // current row bano
            List<Integer> row = new ArrayList<>();
            // trasverse all the column 
            for(int j=0;j<=i;j++){
                // first and last are alwas 1
                if(j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            // store row currnt
            ans.add(row);
        }
        return ans;


    }
}