class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        // go through the loop codntion first to iteraive all of length
        for(int i=1; i<=n; i++){
            // check the conditon first where is divisible by 3  ans 5
            if(i % 3 == 0 && i%5==0){
                ans.add("FizzBuzz");
            }else if(i%3 == 0){
                ans.add("Fizz");
            }else if(i%5 == 0){
                ans.add("Buzz");
            }else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
        
        

    }
}