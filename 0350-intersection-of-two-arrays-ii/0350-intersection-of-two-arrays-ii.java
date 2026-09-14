class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int freqArray[] = new int[1001];
        // cal the frequency for num1
        for(int num:nums1){
            // frequecy badwo
            freqArray[num]++;
        }
            // search arr
            ArrayList<Integer>List= new ArrayList<>();
            for(int num:nums2){
                if(freqArray[num]>0){
                    List.add(num);
                    // down the frequrcy
                    freqArray[num]--;
                }
            }
            // size of aaray
            int k = List.size();
            int result[] = new int[k];
            for(int i=0;i<k;i++){
                result[i]= List.get(i);
            }


        return result;
    }
}