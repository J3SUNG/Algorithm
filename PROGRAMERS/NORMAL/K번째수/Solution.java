import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; ++i) {;
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int pos = commands[i][2] - 1;
            int size = end - start + 1;
            
            int[] arr = new int[size];
            for(int j=0; j<size; ++j){
                arr[j] = array[start + j];
            }
            
            Arrays.sort(arr);            
            answer[i] = arr[pos];
        }
        
        return answer;
    }
}