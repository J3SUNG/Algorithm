import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        boolean[] visit = new boolean[100_001];
        
        boolean start = false;
        String str = "";
        ArrayList<ArrayList<Integer>> al = new ArrayList();
        ArrayList temp = new ArrayList<>();
            
        for(int i=1; i<s.length() - 1; ++i) {
            if(!start && s.charAt(i) == '{') {
                start = true;
                temp = new ArrayList<>();
            } else if(start) {
                if(s.charAt(i) == '}') {
                    temp.add(Integer.parseInt(str));
                    al.add(temp);
                    str = "";                    
                    start = false;
                } else if(s.charAt(i) == ',') {
                    temp.add(Integer.parseInt(str));
                    str = "";
                } else {
                    str += s.charAt(i);
                }
            }
        }
        
        answer = new int[al.size()];
        Collections.sort(al, (a, b) -> a.size() - b.size());
        
        for (int i = 0; i < al.size(); ++i) {            
            for(int j=0; j<=i; ++j) {                
                int num = al.get(i).get(j);
                
                if(visit[num]) continue;
                
                visit[num] = true;
                answer[i] = num;
                break;
            }
        }
        
        return answer;
    }
}