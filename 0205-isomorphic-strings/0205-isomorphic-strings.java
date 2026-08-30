class Solution {
    public boolean isIsomorphic(String s, String t) {
        int [] m1 = new int[256], m2=new int[256];
        // set length of string
        int n = s.length();
        // loop through character
        for(int i=0;i<n;i++){
            // return fasle id mapping inconsistant
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]){
                return false;
            }
            // update last seen index for both char
            m1[s.charAt(i)]=i+1;
            m2[t.charAt(i)]=i+1;
        }
        return true;
    }
}