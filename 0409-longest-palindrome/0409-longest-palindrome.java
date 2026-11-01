class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            freq.put(ch,freq.getOrDefault(ch,0)+1);

        }
        int length = 0;
        // har character ko pairs nikalna
        for(int count:freq.values()){
            length +=(count/2)*2;
        }
        // agar koie odd count hai
        if(length<s.length()){
            length++;
        }
        return length;
    }
}