class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a = gcd(n,m);
        int b = n * m / a;
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
    int gcd(int a, int b) {
	if(b == 0) return a;
	return gcd(b, a % b);
}
}