import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = 0;
		int[][] map = new int[n][m];
		int[][] figy3 = {{0,0}, {1,0}, {2,0}, {3,0}};  //세로 직선, y+3 
		int[][] figx3 = {{0,0}, {0,1}, {0,2}, {0,3}};  //가로직선, x+3
		int[][] figy1x1 = {{0,0}, {0,1}, {1,0}, {1,1}};	//사각형, x+1, y+1
		int[][][] figy2x1 = {	//L, N, T, x+1, y+2 
				{{0,0}, {1,0}, {2,0}, {0,1}},	//L
				{{0,1}, {1,1}, {2,1}, {0,0}},
				{{0,0}, {1,0}, {2,0}, {2,1}},
				{{0,1}, {1,1}, {2,1}, {2,0}},
				{{0,0}, {1,0}, {1,1}, {2,1}},	//N
				{{0,1}, {1,0}, {1,1}, {2,0}},		
				{{0,0}, {1,0}, {2,0}, {1,1}},	//T
				{{0,1}, {1,1}, {2,1}, {1,0}}
		}; 
		int[][][] figy1x2 = { //L, N, T, x+2, y+1
				{{0,0}, {0,1}, {0,2}, {1,2}},	//L
				{{1,0}, {1,1}, {1,2}, {0,2}},
				{{0,0}, {0,1}, {0,2}, {1,0}},
				{{1,0}, {1,1}, {1,2}, {0,0}},
				{{1,0}, {1,1}, {0,1}, {0,2}},	//N
				{{0,0}, {0,1}, {1,1}, {1,2}},
				{{0,0}, {0,1}, {0,2}, {1,1}},	//T
				{{1,0}, {1,1}, {1,2}, {0,1}}
		}; 
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; ++i) {
			for(int j=0; j<m; ++j) {
				int sum;
				if(i+3 < n) { //y+3
					sum = 0;
					for(int k=0; k<4; ++k) { 
						sum += map[i+figy3[k][0]][j+figy3[k][1]];
					}
					max = Math.max(max, sum);
				}
				if(j+3 < m) {	//x+3
					sum = 0;
					for(int k=0; k<4; ++k) { 
						sum += map[i+figx3[k][0]][j+figx3[k][1]];
					}
					max = Math.max(max, sum);
				}
				if(i+1 < n && j+1 < m) { //square
					sum = 0;
					for(int k=0; k<4; ++k) {
						sum += map[i+figy1x1[k][0]][j+figy1x1[k][1]];
					}
					max = Math.max(max, sum);
				}
				if(i+2 < n && j+1 < m) { //L, N, T, x+1 y+2 
					for(int k=0; k<8; ++k) {
						sum = 0;
						for(int l=0; l<4; ++l) {
							sum += map[i+figy2x1[k][l][0]][j+figy2x1[k][l][1]];
						}
						max = Math.max(max, sum);
					}
				}
				if(i+1 < n && j+2 < m) { //L, N, T, x+2, y+1
					for(int k=0; k<8; ++k) {
						sum = 0;
						for(int l=0; l<4; ++l) {
							sum += map[i+figy1x2[k][l][0]][j+figy1x2[k][l][1]];
						}
						max = Math.max(max, sum);
						if(max == 21)
						{
							System.out.println(k);
						}
					}
				}
			}
		}
		bw.write(max + "");
		bw.close();
	}
}
