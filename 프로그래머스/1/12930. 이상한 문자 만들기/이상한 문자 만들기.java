class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0; // 단어 내 인덱스

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append(c);
                idx = 0; // 단어가 끝났으므로 인덱스 초기화
            } else {
                if (idx % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                idx++;
            }
        }
        return sb.toString();
    }
}
