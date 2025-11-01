import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inCommendOrInt = Integer.parseInt(br.readLine());

        for (int i = 0; i < inCommendOrInt; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            int data = 0;
            if (input.length > 1) {
                data = Integer.parseInt(input[1]);
            }

            switch (command) {
                case "push":
                    stack.push(data);
                    break;

                case "pop":
                    if (stack.empty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;

                case "top":
                    if (stack.empty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if (stack.empty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
            }
        }
    }
}