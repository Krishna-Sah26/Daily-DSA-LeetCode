class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor^=num;
        }
        // your select right most bit
        int rightmostBit = xor&(-xor);
        int a=0;
        int b = 0;
        for(int num:nums){
            // agar group 1 hai tho group 1 mha dalado
            if((num & rightmostBit)!=0){
                a^=num;
            }else{
                b^=num;
            }

        }
        return new int[]{a,b};
    }
}