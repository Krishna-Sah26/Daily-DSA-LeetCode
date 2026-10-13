class Solution {
    List<String> result = new ArrayList<>();
    public List<String> solve (int idx, String digits,String temp,Map<Character,String>mp){
        if(idx >= digits.length()){
           result.add(temp);
           return result;
        }
        char ch = digits.charAt(idx);
        String str = mp.get(ch);

        for(int i=0; i<str.length();i++){
            // do karaha hai the
            // character addd karo
            char c = str.charAt(i);
            temp = temp+c;
            
            solve(idx+1,digits,temp,mp);
            
            // backtracking or last character remove karo
            temp = temp.substring(0,temp.length()-1);
        }
        return result;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return result;
        }
        
        // map mha store karo sab ka character 
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        String temp = "";
         solve(0,digits,temp,mp);
         return result;
    }
}