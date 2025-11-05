import java.util.stream.LongStream;

class Solution {
    public long solution(int a, int b) {
        if(a > b) {
            return LongStream.range(b, a + 1).sum();
        } else if(a < b) {
            return LongStream.range(a, b + 1).sum();
        } else {
            return a;
        }
    }
}