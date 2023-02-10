import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] nutrients = new int[n][n];
		int[][] map = new int[n][n];
		int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
		Tree[] arr = new Tree[m];
//		PriorityQueue<Tree> trees = new PriorityQueue<>((o1, o2) -> (o1.y==o2.y ? (o1.x==o2.x ? o1.z-o2.z : o1.x-o2.x) : o1.y-o2.y));
		Queue<Tree> trees = new LinkedList<>();
		Queue<Tree> temp = new LinkedList<>();
		Queue<Tree> babyTree = new LinkedList<>();
		Queue<Tree> deadTrees = new LinkedList<>();
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				map[i][j] = 5;
				nutrients[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<m; ++i) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			arr[i] = (new Tree(x, y, z));
//			trees.add(new Tree(x, y, z));
		}
		Arrays.sort(arr, (o1, o2) -> (o1.y==o2.y ? (o1.x==o2.x ? o1.z-o2.z : o1.x-o2.x) : o1.y-o2.y));
		for(int i=0; i<m; ++i) {
			trees.add(arr[i]);
		}
		for(int y=0; y<k; ++y) {
			while(!trees.isEmpty()) {
				Tree t = trees.poll();
				if(map[t.y][t.x] >= t.z) {
					map[t.y][t.x] -= t.z;
					++t.z;
					temp.add(t);
				} else {
					deadTrees.add(t);
				}
			}
			while(!temp.isEmpty()) {
				trees.add(temp.poll());
			}
			while(!deadTrees.isEmpty()) {
				Tree t = deadTrees.poll();
				map[t.y][t.x] += (t.z/2); 
			}
			while(!trees.isEmpty()) {
				Tree t = trees.poll();
				temp.add(t);
				if(t.z % 5 == 0) {
					for(int i=0; i<8; ++i) {
						if(t.y + dy[i] < 0 || t.x + dx[i] < 0 || t.y + dy[i] >= n || t.x + dx[i] >= n) {
							continue;
						}
						babyTree.add(new Tree(t.x + dx[i], t.y + dy[i], 1));
					}
				}
			}
			while(!babyTree.isEmpty()) {
				trees.add(babyTree.poll());
			}
			while(!temp.isEmpty()) {
				trees.add(temp.poll());
			}
			
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					map[i][j] += nutrients[i][j];
				}
			}
		}
		bw.write(trees.size() + "");
		bw.close();
	}
	static class Tree {
		int x;
		int y;
		int z;
		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}

