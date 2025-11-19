class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            int result = (int)Math.sqrt(i);
            if(result * result == i) {
                sum -= i;
            } else{
                sum += i;
            }
        }
        return sum;
    }
}