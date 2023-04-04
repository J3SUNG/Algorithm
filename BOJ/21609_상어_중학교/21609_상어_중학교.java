import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int ans;
	static int n;
	static int m;
	static int[][] map;
	static int[][] visit;
	static int goodY;
	static int goodX;
	static int goodCnt;
	static int goodRBCnt;
	static int goodMaxRow;
	static int goodMaxCol;
	static int curY;
	static int curX;
	static int curCnt;
	static int curRBCnt;
	static int curMaxRow;
	static int curMaxCol;

	public static void main(String[] args) throws Exception {
		input();
		Simulation();

		bw.write(ans + "\n");
		bw.close();
	}

	public static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new int[n][n];

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void Simulation() {
		goodY = -1;
		goodX = -1;
		goodCnt = -1;
		goodRBCnt = -1;
		goodMaxRow = -1;
		goodMaxCol = -1;

		InitVisit();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (visit[i][j] > 0 || map[i][j] <= 0) {
					continue;
				}
				curY = i;
				curX = j;
				curCnt = 0;
				curRBCnt = 0;
				curMaxRow = -1;
				curMaxCol = -1;
				find(i, j, map[i][j]);
				InitRB();
				if (!Renewal()) {
					continue;
				}
				change();
			}
		}
		if (goodCnt < 2) {
			return;
		}
		RemoveBlock(goodY, goodX, map[goodY][goodX]);
		ans += goodCnt * goodCnt;
		Gravity();
		Rotate();
		Gravity();
		Simulation();
	}

	public static void InitVisit() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				visit[i][j] = 0;
			}
		}
	}

	public static void find(int y, int x, int findNum) {
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, -1, 0, 1 };
		if (map[y][x] == 0) {
			visit[y][x] = 2;
		} else if (map[y][x] == findNum) {
			visit[y][x] = 1;
		}

		++curCnt;
		if (map[y][x] == 0) {
			++curRBCnt;
		}
		if (map[y][x] == findNum) {
			if (curMaxRow > y || (curMaxRow == y && curMaxCol > x)) {
				curMaxCol = x;
				curMaxRow = y;
			}
		}
		for (int i = 0; i < 4; ++i) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
				continue;
			}
			if (visit[nextY][nextX] >= 1 || (map[nextY][nextX] != findNum && map[nextY][nextX] > 0)
					|| map[nextY][nextX] < 0) {
				continue;
			}
			find(nextY, nextX, findNum);
		}
	}

	public static void InitRB() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (visit[i][j] == 2) {
					visit[i][j] = 0;
				}
			}
		}
	}

	public static boolean Renewal() {
		if (goodCnt > curCnt) {
			return false;
		} else if (goodCnt < curCnt) {
			return true;
		}
		if (goodRBCnt > curRBCnt) {
			return false;
		} else if (goodRBCnt < curRBCnt) {
			return true;
		}
		if (goodMaxRow > curMaxRow) {
			return false;
		} else if (goodMaxRow < curMaxRow) {
			return true;
		}
		if (goodMaxCol > curMaxCol) {
			return false;
		} else if (goodMaxCol < curMaxCol) {
			return true;
		}

		return true;
	}

	public static void change() {
		goodY = curY;
		goodX = curX;
		goodCnt = curCnt;
		goodRBCnt = curRBCnt;
		goodMaxCol = curMaxCol;
		goodMaxRow = curMaxRow;
	}

	public static void RemoveBlock(int y, int x, int findNum) {
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, -1, 0, 1 };
		map[y][x] = -2;
		for (int i = 0; i < 4; ++i) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
				continue;
			}
			if (map[nextY][nextX] == findNum || map[nextY][nextX] == 0) {
				RemoveBlock(nextY, nextX, findNum);
			}
		}
	}

	public static void Gravity() {
		Queue<Pair> q = new LinkedList<>();
		for (int j = 0; j < n; ++j) {
			for (int i = n - 1; i >= 0; --i) {
				if (map[i][j] == -1) {
					while (!q.isEmpty()) {
						q.poll();
					}
				} else if (map[i][j] == -2) {
					q.add(new Pair(i, j));
				} else {
					if (q.size() > 0) {
						Pair p = q.poll();
						map[p.y][p.x] = map[i][j];
						map[i][j] = -2;
						q.add(new Pair(i, j));
					}

				}
			}
			while (!q.isEmpty()) {
				q.poll();
			}
		}
	}

	public static void Rotate() {
		int[][] tempMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tempMap[i][j] = map[j][n - 1 - i];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = tempMap[i][j];
			}
		}
	}

	public static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void ShowMap() {
		System.out.println();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.printf("%d ", map[i][j] == -1 ? 9 : map[i][j] == -2 ? 8 : map[i][j]);
			}
			System.out.println();
		}
	}
}
