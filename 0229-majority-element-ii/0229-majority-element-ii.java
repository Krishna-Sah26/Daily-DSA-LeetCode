class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        // two count and two cand

        int count1=0;
        int count2=0;
        int cand1=0;
        int cand2=0;
        // step 1 // find two possible cand
        for(int num:nums){
            if(num==cand1){
                count1++;
            }
            else if(num==cand2){
                count2++;
            }
            else if(count1==0){
                cand1 = num;
                count1 = 1;
            }
            else if (count2==0){
                cand2 = num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        // find the actual frq
         count1=0;
         count2=0;
         for(int num:nums){
            if(num==cand1){
                count1++;
            }
            if(num==cand2){
                count2++;
            }
         }
         // store all the value
         List<Integer>ans= new ArrayList<>();
         if(count1>n/3){
            ans.add(cand1);
         }
         if(count2>n/3 &&  cand2 != cand1){
            ans.add(cand2);
         }
         return ans;
    }
}