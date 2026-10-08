class Solution {
     long M = 1000000007L;
    public int finpower(long a, long b){
        if(b==0){
            return 1;   
        }
        long half = finpower(a,b/2);
        long result = (half*half)% M;
        if(b%2==1){
            result = (result*a)%M;
        }
        return (int)result;
    }
    public int countGoodNumbers(long n) {
       return (int)((long) finpower(5, (n + 1) / 2) * finpower(4, n / 2) % M);
        
    }
}