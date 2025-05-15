import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] cntArr = new int[10];
        Queue<int[]> q = new LinkedList();
        int max = 0;
        int cnt = 0;
        
        for(int i=0; i<priorities.length; ++i) {
            int num = priorities[i]; 
            int[] arr = {i, num};
            
            ++cntArr[num];            
            max = Math.max(max, num);            
            q.add(arr);
        }
        
        while(q.size() > 0) {            
            int[] data = q.poll();
                        
            if(data[1] == max) {                
                --cntArr[max];
                ++cnt;
                if(data[0] == location) {
                    answer = cnt;
                    break;
                }                
                
                while(max > 0 && cntArr[max] == 0) {
                    --max;
                }
            } else {
                q.add(data);
            }
        }        
        
        return answer;
    }
}