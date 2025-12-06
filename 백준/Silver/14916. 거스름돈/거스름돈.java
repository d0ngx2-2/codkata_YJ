import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 예외 처리
        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        int five = n / 5;

        // 나머지 1 또는 3 → 5원 하나 빼서 조정
        if (n % 5 == 1 || n % 5 == 3) {
            five -= 1;
        }

        int remain = n - (five * 5);
        int two = remain / 2;

        System.out.println(five + two);
    }
}
