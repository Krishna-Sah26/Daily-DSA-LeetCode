class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int l=0;
        int r=0;
       int minLength = Integer.MAX_VALUE;
       int startIndex = -1;
        int count=0;
        int m = t.length();
        for(int i =0; i<m; i++){
            hash[t.charAt(i)]++;
        }
            while(r<s.length()){
                if(hash[s.charAt(r)]>0){
                    count = count+1;
                }
                hash[s.charAt(r)]--;
                while(count==m){
                    if(r-l+1<minLength){
                        minLength = r-l+1;
                        startIndex = l;
                    }
                    
                    hash[s.charAt(l)]++;
                    if(hash[s.charAt(l)]>0){
                        count--;
                    }
                    l++;
                }
                r= r+1;
            }

         return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}