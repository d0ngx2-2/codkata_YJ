class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        if(arr.length % 2 == 0){
            answer = arr[arr.length / 2 - 1] + arr[arr.length / 2];   
        } else if(arr.length % 2 == 1){
            answer = arr[arr.length / 2];
        }
        return answer;
    }
}