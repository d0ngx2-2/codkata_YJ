
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 총 포켓몬 개수 N, 질문 개수 M
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        // 2) 두 방향으로 찾기 위한 Map 준비
        Map<Integer, String> numToName = new HashMap<>(); // 번호 -> 이름
        Map<String, Integer> nameToNum = new HashMap<>(); // 이름 -> 번호

        // 3) N개의 포켓몬 정보 입력
        //    i는 번호 그 자체가 됨 (1부터 시작)
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            numToName.put(i, name);   // 번호로 이름 찾기
            nameToNum.put(name, i);   // 이름으로 번호 찾기
        }

        StringBuilder sb = new StringBuilder();

        // 4) M개의 질문 처리
        for (int i = 0; i < m; i++) {
            String query = br.readLine();

            // 숫자인지 이름인지 구분 필요
            // → Character.isDigit() 로 간단하게 판단
            if (Character.isDigit(query.charAt(0))) {
                // 숫자면 문자열을 int로 바꿔서 이름 조회
                int number = Integer.parseInt(query);
                sb.append(numToName.get(number)).append("\n");
            } else {
                // 이름이면 번호 조회
                sb.append(nameToNum.get(query)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
