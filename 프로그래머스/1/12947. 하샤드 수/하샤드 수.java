class Solution {
    public boolean solution(int x) {
        int sum = 0;
        String data = String.valueOf(x);
        String[] arr = data.split("");
        int[] iarr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            iarr[i] = Integer.parseInt(arr[i]);
            sum+=iarr[i];    
        }
        if(x % sum == 0){
            return true;
        } else {
         return false;   
        }
    }
}