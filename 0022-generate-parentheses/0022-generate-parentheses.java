class Solution {
    // create the store of parthusis
    List<String>result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        int open = 0;
        int close = 0;
        solve(curr,n,open,close);
        return result;
    }
    public void solve(StringBuilder curr,int n , int open,int close){
        // base case 
        if(curr.length()==2*n){
             result.add(curr.toString());
             return;
        }
        // add '('
        if(open<n){
            curr.append('(');
            solve(curr, n,open+1,close);
            curr.deleteCharAt(curr.length()-1);
        }
        // Add ')';
        if(close<open){
            curr.append(')');
            solve(curr,n,open,close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}