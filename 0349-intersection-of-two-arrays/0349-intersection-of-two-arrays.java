class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // create the hashset
        HashSet<Integer> set = new HashSet<>();
        for(int n2 :nums2){
            set.add(n2);
        }
        // create the aaray for the 
        ArrayList<Integer>List = new ArrayList<>();
          for(int n1:nums1){
            if(set.contains(n1)){
                List.add(n1);
                set.remove(n1);
            }

          }
          int result[] = new int[List.size()];
          for(int i=0;i<List.size();i++){
            result[i] = List.get(i);
          }
          return result;
    }
}