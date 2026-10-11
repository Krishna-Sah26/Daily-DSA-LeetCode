class Solution {
    public void getcombination(int[]arr,int idx,int tar,List<List<Integer>>ans,List<Integer>combin){
        // base case
        if(tar==0){
            ans.add(new ArrayList<>(combin));
            return;
        }
        for(int i=idx; i<arr.length;i++){
            // same level par duplicate skip karo
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }
            // aaray sorted hai isliya aage ke numver bhi badde hoga
            if(arr[i]>tar){
                break;
            }
            // pick current numbe
            combin.add(arr[i]);
            // i+1 har candidate sirf ek barr use hoge
            getcombination(arr,i+1,tar-arr[i],ans,combin);
            // backtracking
            combin.remove(combin.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>combin = new ArrayList<>();
        getcombination(candidates,0,target,ans,combin);
        return ans;
    }
}