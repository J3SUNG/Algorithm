class Solution {
    public int solution(int n) {
        int answer = 0;
        int l = 1;
        int r = 1;
        int sum = 1;
        
        while(r <= n) {
           if (sum == n) answer++;
            
            if (sum >= n) {
                sum -= l;
                l++;
            } else {
                r++;
                sum += r;
            }
        }
        
        return answer;
    }
}