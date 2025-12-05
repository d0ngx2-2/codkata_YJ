import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringBuilder line = new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i = 0; i < a; i++) {
            line.append("*");
        }
        for(int i = 0; i < b; i++) {
            sb.append(line).append("\n");
        }
        System.out.print(sb);
    }
}