import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = -1;

        // 5원을 최대한 많이 쓴다.
        int five = n / 5;

        while (five >= 0) {
            int remain = n - (five * 5);

            // 나머지가 0이면 끝
            if (remain % 2 == 0) {
                answer = five + (remain / 2);
                break;
            }

            // 2로 안 나누어지면 5원 하나 줄여서 다시
            five--;
        }

        System.out.println(answer);
    }
}