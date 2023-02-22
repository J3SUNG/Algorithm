import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        char[] c = {'^', 'v', '<', '>', '.', '*', '#', '-'};
        char[] move = {'U', 'D', 'L', 'R', 'S'};
        int ts = Integer.parseInt(br.readLine());
        for(int t=1; t<=ts; ++t) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};
            int[][] map = new int[h][w];
            int y = 0;
            int x = 0;
            int d = 0;
            String str;
            for(int i=0; i<h; ++i) {
                str = br.readLine();
                for(int j=0; j<w; ++j) {
                    for(int k=0; k<8; ++k) {
                        if(str.charAt(j) == c[k]) {
                            map[i][j] = k;
                            if(k < 4) {
                                y = i;
                                x = j;
                                d = k;
                            }
                            break;
                        }
                    }
                }
            }
            int n = Integer.parseInt(br.readLine());
            str = br.readLine();
            for(int i=0; i<n; ++i) {
                int act = 0;
                for(int j=0; j<5; ++j) {
                    if(str.charAt(i) == move[j]) {
                        act = j;
                        break;
                    }
                }
                if(act == 4) { //shoot
                    int nextY = y + dy[d];
                    int nextX = x + dx[d];
                    while(true) {                   
                        if(nextY < 0 || nextX < 0 || nextY >=h || nextX >= w) {
                            break;                      
                        }
                        if(map[nextY][nextX] == 5) {
                            map[nextY][nextX] = 4;
                            break;
                        }
                        if(map[nextY][nextX] == 6) {
                            break;
                        }
                        nextY += dy[d];
                        nextX += dx[d];
                    }
                } else { // move
                    int nextY = y + dy[act];
                    int nextX = x + dx[act];
                    if(nextY < 0 || nextX < 0 || nextY >=h || nextX >= w || map[nextY][nextX] != 4) {
                        map[y][x] = act;                    
                    }
                    else {
                        map[nextY][nextX] = act;
                        map[y][x] = 4;
                        y = nextY;
                        x = nextX;
                    }
                    d = act;
                }
            }
            bw.write("#" + t + " ");
            for(int i=0; i<h; ++i) {
                for(int j=0; j<w; ++j) {
                    bw.write(c[map[i][j]]);
                }
                bw.write("\n");
            }
        }
                 
        bw.close();
    }
}