import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> cranes = new ArrayList<>();
        for (int i = 0; i < N; i++) cranes.add(sc.nextInt());

        int M = sc.nextInt();
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) boxes.add(sc.nextInt());

        // 크레인, 박스 모두 내림차순 정렬
        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        // 무거운 박스를 들 수 있는 크레인이 없으면 불가능
        if (boxes.get(0) > cranes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        // 박스가 모두 없어질 때까지 반복
        while (!boxes.isEmpty()) {
            int boxIdx = 0;    // 현재 보고 있는 박스
            int craneIdx = 0;  // 현재 사용 중인 크레인

            // 한 분 동안 모든 크레인이 박스를 하나씩 옮김
            while (craneIdx < cranes.size()) {
                if (boxIdx >= boxes.size()) break;  // 박스 다 봤으면 종료

                if (cranes.get(craneIdx) >= boxes.get(boxIdx)) {
                    // 들 수 있는 박스 발견 → 바로 제거
                    boxes.remove(boxIdx);
                    craneIdx++;
                } else {
                    // 현재 크레인이 못 들면 더 가벼운 박스 탐색
                    boxIdx++;
                }
            }

            time++;
        }

        System.out.println(time);
    }
}
