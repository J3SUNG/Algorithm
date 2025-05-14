class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] arr = s.split(" ", -1);
        for(int i=0; i<arr.length; ++i){
            for(int j=0; j<arr[i].length(); ++j){
                String ch = String.valueOf(arr[i].charAt(j));

                if(j % 2 == 0) {
                    sb.append(ch.toUpperCase());
                } else {
                    sb.append(ch.toLowerCase());
                }
            }
            
            if(i < arr.length - 1) sb.append(" ");
        }
        
        return sb.toString();
    }
}