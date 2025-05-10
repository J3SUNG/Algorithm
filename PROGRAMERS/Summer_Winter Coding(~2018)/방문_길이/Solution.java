import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] moveY = {-1, 0, 1, 0};
        int[] moveX = {0, 1, 0, -1};
        int MAX_RANGE = 11;
        
        Set<String> set = new HashSet<>();
        
        int y = 5;
        int x = 5;
        for(int i=0; i<dirs.length(); ++i) {
            int ny = 0;
            int nx = 0;
            if(dirs.charAt(i) == 'U') {
                ny = y + moveY[0];
                nx = x + moveX[0];
            } else if(dirs.charAt(i) == 'R') {
                ny = y + moveY[1];
                nx = x + moveX[1];
            } else if(dirs.charAt(i) == 'D') {
                ny = y + moveY[2];
                nx = x + moveX[2];
            } else if(dirs.charAt(i) == 'L') {
                ny = y + moveY[3];
                nx = x + moveX[3];
            }
            
            if(ny < 0 || nx < 0 || ny >= MAX_RANGE || nx >= MAX_RANGE) continue;
                        
            String curPos = y + " " + x;
            String nextPos = ny + " " + nx;
            
            if(!set.contains(curPos + " " + nextPos)) {
                set.add(curPos + " " + nextPos);
                set.add(nextPos + " " + curPos);
            }
            
            y = ny;
            x = nx;
        }
        
        return set.size() / 2;
    }
}