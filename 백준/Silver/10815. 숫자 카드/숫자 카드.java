
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 내가 가진 카드 수
        int n = Integer.parseInt(br.readLine());
        String[] myCards = br.readLine().split(" ");

        // HashSet 생성 — O(1)에 조회할 수 있는 구조
        HashSet<Integer> set = new HashSet<>();

        // 2) 카드 숫자들을 HashSet에 하나씩 넣기
        //    add()는 중복이 있으면 그냥 무시. 자동으로 "집합" 형태가 됨.
        for (String s : myCards) {
            set.add(Integer.parseInt(s));
        }

        // 3) 상대가 물어보는 숫자 개수
        int m = Integer.parseInt(br.readLine());
        String[] targets = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        // 4) 물어보는 숫자들에 대해 contains()로 존재 여부 확인
        //    — 이게 바로 HashSet을 쓰는 이유! 평균 O(1)
        for (String t : targets) {
            int num = Integer.parseInt(t);

            if (set.contains(num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        // 5) 결과 출력
        System.out.print(sb.toString());
    }
}
