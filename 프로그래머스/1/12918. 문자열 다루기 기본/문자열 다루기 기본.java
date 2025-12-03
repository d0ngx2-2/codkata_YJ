class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        String arr[] = s.split("");
        if(arr.length == 4 || arr.length == 6) {
            for(int i = 0; i < arr.length; i++) {
                if(!Character.isDigit(arr[i].charAt(0))) {
                    return answer = false;
                    }   
                }
            return answer = true;
        }
        else {answer = false;}
        return answer;
    }
}