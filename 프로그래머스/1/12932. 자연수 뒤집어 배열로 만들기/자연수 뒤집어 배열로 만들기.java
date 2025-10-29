import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> reverseList = new ArrayList<>();

        while (n > 0) {
            int reverseNum = (int)(n % 10);
            reverseList.add(reverseNum); 
            n /= 10; 
        }

        int[] answer = new int[reverseList.size()];
        for (int i = 0; i < reverseList.size(); i++) {
            answer[i] = reverseList.get(i);
        }
        return answer;
    }
}