class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        int answer = 0;
        for(int i = 0;i < numbers.length; i++) sum += numbers[i];
        answer = 45 - sum;
        return answer;
    }
}