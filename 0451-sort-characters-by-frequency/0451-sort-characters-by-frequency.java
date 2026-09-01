class Solution {
    public String frequencySort(String s) {
        // Acii character of frequecny
        int [] freq = new int[256];
        // count the frquency
        for(char ch:s.toCharArray()){
            freq[ch]++;
        }
        // to sort all the according frequecnvy
        StringBuilder ans = new StringBuilder();
        while(ans.length()<s.length()){
            int maxfreq = 0;
            int maxChar = 0;
            // find the frequcny where higest of freq character
            for(int i=0;i<256;i++){
                if(freq[i]>maxfreq){
                    maxfreq = freq[i];
                    maxChar =i;
                }
 
            }
            /// to find the maxtime charan add all
            for(int i=0;i<maxfreq;i++){
                ans.append((char)maxChar);
            }
            // char ko doobar selesct na kara
            freq[maxChar]=0;
        }
        return ans.toString();
        
    }
}