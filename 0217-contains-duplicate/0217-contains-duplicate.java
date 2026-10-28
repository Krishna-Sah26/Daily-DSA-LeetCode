class Solution {
    public boolean containsDuplicate(int[] nums) {
      // to create the hashset for the store data in map
      HashSet<Integer> ans = new HashSet<>();
       // check 
       for(int num:nums){
        if(ans.contains(num)){
            return true;
        }
        ans.add(num);
       } 
       return false;
    }
}