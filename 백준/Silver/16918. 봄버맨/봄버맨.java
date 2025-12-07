import java.util.*;

public class Main {

    static int R, C, N;      // 행, 열, 시간 → 전역으로 두면 여러 메서드에서 쉽게 접근 가능
    static char[][] initial; // 초기 입력 상태
    static char[][] full;    // 모든 칸이 폭탄인 상태 (짝수 초에서 사용)
    static char[][] boom1;   // 첫 번째 폭발 결과 (t=3)
    static char[][] boom2;   // 두 번째 폭발 결과 (t=5)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 크기 받기
        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine(); // 개행 제거 (다음 줄 입력 위해 필요)

        // 초기 맵 입력 받기
        initial = new char[R][C];
        for (int i = 0; i < R; i++) {
            initial[i] = sc.nextLine().toCharArray(); 
            // 한 줄씩 받고 char[]로 변환 → 다루기 쉽기 때문
        }

        full = makeFullBoard();    // 전부 'O'로 채운 맵 생성
        boom1 = explode(initial);  // t=3 결과 미리 계산
        boom2 = explode(boom1);    // t=5 결과 미리 계산

        print(selectBoard());      // 시간 N에 해당하는 최종 결과 출력
    }

    // ------------------ 최종 맵 선택 로직 ------------------

    // 시간 N에 따라 어떤 맵을 출력할지 결정하는 메서드
    private static char[][] selectBoard() {

        if (N == 1) return initial; // 1초는 입력 그대로

        if (N % 2 == 0) return full; 
        // 짝수 초는 무조건 모든 칸 폭탄 → 시뮬레이션 필요 없음

        if (N % 4 == 3) return boom1; 
        // 3초, 7초, 11초… → 첫 번째 폭발 패턴 반복

        return boom2; 
        // 5초, 9초, 13초… → 두 번째 폭발 패턴 반복
    }

    // ------------------ 모든 칸 폭탄 보드 생성 ------------------

    private static char[][] makeFullBoard() {
        char[][] map = new char[R][C];  // 새로운 보드 생성
        for (int i = 0; i < R; i++) {
            Arrays.fill(map[i], 'O');  
            // 행 단위로 'O'로 채우는 게 가장 빠르고 깔끔
        }
        return map;
    }

    // ------------------ 폭발 시뮬레이션 ------------------

    private static char[][] explode(char[][] board) {
        // 기본적으로 폭발 후 남는 영역은 폭탄으로 가득하므로 'full'을 기반으로 시작
        char[][] next = makeFullBoard();

        // 폭발 범위 정의 (자기 자신 + 상하좌우)
        int[] dx = {1, -1, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0};
        // dx, dy를 배열로 관리하면 폭발 범위를 반복문으로 처리 가능 → 깔끔 & 유지보수 쉬움

        for (int x = 0; x < R; x++) {         // 모든 좌표 탐색
            for (int y = 0; y < C; y++) {

                if (board[x][y] == 'O') {     // 현재 위치에 폭탄이 있으면
                    for (int i = 0; i < 5; i++) { // 자기 + 상하좌우
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        // 보드 범위를 벗어나지 않는지 체크
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            next[nx][ny] = '.'; // 폭발 영향 → 비어있는 칸으로 변경
                        }
                    }
                }
            }
        }

        return next; // 폭발 이후의 새로운 보드 반환
    }

    // ------------------ 출력 담당 ------------------

    private static void print(char[][] board) {
        StringBuilder sb = new StringBuilder(); // 출력 성능 개선

        for (int i = 0; i < R; i++) {
            sb.append(board[i]).append('\n'); 
            // char[] 바로 append하면 문자열로 붙어서 출력됨
        }

        System.out.print(sb); 
        // 마지막에 한 번만 출력 → 시간 절약
    }
}
