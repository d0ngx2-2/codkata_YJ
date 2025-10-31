class Solution {
    public long solution(long n) {
        for(long i = 1; i * i <= n; i++) {
            if (i * i == n) {
                long x = i + 1;
                return x * x;    
            }
        }
        return -1;
    }
}