import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int num : scoville) {
            pq.add(num);
        }        
        
        while(pq.size() >= 2 && pq.peek() < K) {
            int top = pq.poll();
            int second = pq.poll();
            
            pq.add(top + second * 2);
            ++answer;
        }
        
        if(pq.peek() < K) answer = -1;
        
        return answer;
    }
}