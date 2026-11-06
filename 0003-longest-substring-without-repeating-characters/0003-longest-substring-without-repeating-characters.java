class Solution {
    public int lengthOfLongestSubstring(String s) {
        // map data stracture 
       int [] hash = new int[256];
       Arrays.fill(hash,-1);
        int left = 0;
        int right = 0;
        int maxlength = 0;
        int n = s.length();
        while(right<n){
            char currentChar = s.charAt(right);
            // check is charatcer is map or not
            if(hash[currentChar]!=-1){
                if(hash[currentChar]>=left){
                    left= hash[currentChar]+1;
                }
            }
            // caluclate lenth and upadte mac
           int currentLength = right - left + 1;
            maxlength = Math.max(maxlength, currentLength);
            // store/ update the latest index of charatcer
            hash[currentChar] = right;
            right++;
        }
        return maxlength;
    }
}