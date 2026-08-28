class Solution {
    public String removeOuterParentheses(String s) {
        // intilize the result of string
        StringBuilder result = new StringBuilder();
        int level = 0;
        //travser the String 
        for(char ch : s.toCharArray()){
            // if we counter c increase the level 
            if(ch=='('){
                if(level>0)result.append(ch);
                level++;
            }else if(ch==')'){
                level --;
                if(level>0)result.append(ch);
            }
        }
        return result.toString();

    }
}