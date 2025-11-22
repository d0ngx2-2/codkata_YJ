import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //명 수 N, 치킨 종류 M 입력
        int N = sc.nextInt();
        int M = sc.nextInt();
        //최댓값을 출력할 answer 선언
        int answer = 0;
        
        //2차원 배열 생성 사람명수 크기만큼의 배열, 사람 1명당 치킨종류 크기만큼의 배열을 갖는다.
        //첫번째 사람부터 치킨 종류수의 만큼 선호도의 숫자를 입력받는다.
        int[][] likeNum = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                likeNum[i][j] = sc.nextInt();
            }
        }
        
        //3종류의 치킨의 중복되지 않는 모든 경우의 수를 구한다.
        //a,b,c 는 각각 고를 치킨의 1,2,3번째 치킨을 의미한다.
        //3중 for문에 조건 앞 +1한 이유는 중복되지 않는 경우의 수를 찾기 위해서 이다.
        for (int a = 0; a < M; a++) {
            for (int b = a + 1; b < M; b++) {
                for (int c = b + 1; c < M; c++) {

                    //사람별 3가지 치킨의 가장 큰 값을 더한 수 sum 선언
                    int sum = 0;
                    
                    //i번째 사람의 a,b,c 치킨 중 가장 큰 값을 sum에 더하며 저장
                    for (int i = 0; i < N; i++) {
                        sum += Math.max(likeNum[i][a], Math.max(likeNum[i][b], likeNum[i][c]));
                    }

                    //sum 값을 계속 비교하여 answer 보다 크면 answer로 스왑
                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }
}