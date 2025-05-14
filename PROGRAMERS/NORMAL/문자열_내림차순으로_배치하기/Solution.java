import java.util.*;

class Solution {
    public String solution(String s) {
        Character[] arr = new Character[s.length()];
        for(int i=0; i<s.length(); ++i) {
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr, (a, b) -> b - a);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); ++i) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}