class Solution {
    public void help(int i,int k,int sumTillNow,int n,List<Integer>subSet,List<List<Integer>>ans){
        // if the sumtill greater than n dont processd further
        if(sumTillNow > n)
            return;
            // if k become equal to zero we need to check if 
        if(k==0){
            if(sumTillNow == n){
                ans.add(new ArrayList(subSet));
            }
            // else return
              return;
        }
        if(i==10)
        return;
        sumTillNow+=i;
        subSet.add(i);
        help(i+1,k-1,sumTillNow,n,subSet,ans);
        sumTillNow -=i;
        subSet.remove(subSet.size()-1);
        help(i+1,k,sumTillNow,n,subSet,ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>subSet = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        help(1,k,0,n,subSet,ans);
        return ans;
    }
}