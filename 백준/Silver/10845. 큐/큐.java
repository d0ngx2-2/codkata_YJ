import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException { //예외처리 try-catch말고 가독성을 위해 throws 채택
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Scanner 사용 시 버퍼 및 시간초과로 인해 BuffereadReader 채택 및 생성
        int n = Integer.parseInt(br.readLine()); //입력 받을 n 선언

        int[] Queue = new int[n]; // 입력 받은 수만큼 Queue이라는 수 배열 크기 선언
        int rear = 0;// Queue에 rear의 위치
        int front = 0; // Queue에 front의 위치

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" "); //공백을 통한 입력값 구분 짓기
            String commend = input[0]; //첫번째 입력되는 것을 commend로 구분

            switch (commend) { //commend 입력 시 처리
                case "push": // push 입력 시 top(원소 개수) 1씩 증가 및 입력된 두번째 숫자가 배열에 추가
                    int value = Integer.parseInt(input[1]); //띄어쓰기 후 두번째 숫자를 value로 지정
                    Queue[rear++] = value; // 추가된 배열마다 value값 넣기
                    break;

                case "pop": // pop 입력 시 크기가 0이면 -1 출력, 외 크기 값을 감소시키고 출력
                    if (front == rear) {
                        System.out.println(-1);
                    } else {
                        System.out.println(Queue[front++]);
                    }
                    break;

                case "size": // size입력 시 크기 값을 출력
                    System.out.println(rear - front);
                    break;

                case "empty" : // empty 입력 시 비어있다면 1, 아니면 0을 출력
                    if (rear == front) {
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;

                case "front": // front 입력 시 없으면 1, 외엔 가장 앞에 있는 정수를 출력
                    if (rear == front) {
                        System.out.println(-1);
                    } else {
                        System.out.println(Queue[front]);
                    }
                    break;

                case "back": //back입력 시 0이면 -1, top -1 후 출력(index때문)
                    if (rear == front) {
                        System.out.println(-1);
                    } else {
                        System.out.println(Queue[rear - 1]);
                    }
                    break;
            }
        }
    }
}