class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;

        }
        // concate the both of string 
        String doubledS = s+s;
        return doubledS.contains(goal);

    }
}