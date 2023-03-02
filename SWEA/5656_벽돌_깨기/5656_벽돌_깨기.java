import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int w;
	static int h;
	static int[][] map;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());

		for (int ts = 1; ts <= t; ++ts) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			ans = 987654321;

			for (int i = 0; i < h; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] arr = new int[n];
			for (int i = 0; i < w; ++i) {
				arr[0] = i;
				MakeCom(i, arr, 1);
			}
			bw.write("#" + ts + " " + ans + "\n");
		}
		
		bw.close();
	}

	public static void CountBlock(int[][] newMap) {
		int sum = 0;
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				if (newMap[i][j] == 0) {
					continue;
				}
				++sum;
			}
		}
		ans = Math.min(ans, sum);
	}

	public static void GravityBlock(int[][] newMap) {
		for (int j = 0; j < w; ++j) {
			int index = -1;
			for (int i = h - 1; i >= 0; --i) {
				if (index == -1 && newMap[i][j] != 0) {
					continue;
				} else if (index == -1 && newMap[i][j] == 0) {
					index = i;
				} else if (index != -1 && newMap[i][j] != 0) {
					newMap[index][j] = newMap[i][j];
					newMap[i][j] = 0;
					--index;
				}
			}
		}
	}

	public static void DestroyBlock(int[][] newMap, int y, int x) {
		int newC = newMap[y][x];
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

		newMap[y][x] = 0;
		if (newC == 1) {
			return;
		}

		for (int i = 0; i < 4; ++i) {
			int nextY = y;
			int nextX = x;
			for (int j = 0; j < newC - 1; ++j) {
				nextY += dy[i];
				nextX += dx[i];
				if (nextY < 0 || nextX < 0 || nextY >= h || nextX >= w) {
					break;
				}
				if(newMap[nextY][nextX] == 0) {
					continue;
				}
				else if(newMap[nextY][nextX] == 1) {
					newMap[nextY][nextX] = 0;
				} else {
					DestroyBlock(newMap, nextY, nextX);
				}
			}
		}
	}

	public static void TargetBlock(int[][] newMap, int loc) {
		for (int i = 0; i < h; ++i) {
			if (newMap[i][loc] > 0) {
				DestroyBlock(newMap, i, loc);
				break;
			}
		}
		CountBlock(newMap);
	}

	public static void CreateNewMap(int[][] newMap) {
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	public static void Simulation(int[] arr) {
		int[][] newMap = new int[h][w];
		CreateNewMap(newMap);
		for (int i = 0; i < n; ++i) {
			TargetBlock(newMap, arr[i]);
			GravityBlock(newMap);
		}
	}

	public static void MakeCom(int index, int[] arr, int cnt) {

		if (cnt == n) {
			Simulation(arr);
			return;
		}
		for (int i = 0; i < w; ++i) {
			arr[cnt] = i;
			MakeCom(i, arr, cnt + 1);
		}
	}
}