import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int cnt = 0;
        ArrayList<String> al = new ArrayList<>();
        
        for(int i=0; i<number.length(); ++i) {
            String cur = String.valueOf(number.charAt(i));            
            
            if(al.size() == 0) {
                al.add(cur);
                continue;
            }
            
            while(true) {
                if(al.size() <= 0 || cnt >= k) {
                    al.add(cur);
                    break;
                }
                
                String top = al.get(al.size() - 1);
                
                if(Integer.parseInt(top) < Integer.parseInt(cur)) {
                    al.remove(al.size() - 1);
                    ++cnt;
                } else {
                    al.add(cur);
                    break;
                }
            }
        }
        
        for(int i=0; i<number.length() - k; ++i) {
            answer += al.get(i);
        }
        
        return answer;
    }
}