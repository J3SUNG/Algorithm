import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int bus;
  static ArrayList<ArrayList<Node>> al;
  static PriorityQueue<Node> pq;
  static int start;
  static int end;
  static int[] cost;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    n = Integer.parseInt(br.readLine());
    bus = Integer.parseInt(br.readLine());
    pq = new PriorityQueue<>((a, b) -> {
      return a.weight - b.weight;
    });
    al = new ArrayList<>();
    cost = new int[n];

    for (int i = 0; i < n; ++i) {
      ArrayList<Node> temp = new ArrayList<>();
      al.add(temp);
      cost[i] = 987654321;
    }

    for (int i = 0; i < bus; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken());
      al.get(a).add(new Node(b, c));
    }
    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken()) - 1;
    end = Integer.parseInt(st.nextToken()) - 1;

    cost[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      int index = pq.peek().vertex;
      int value = pq.peek().weight;
      pq.poll();

      if (cost[index] < value) {
        continue;
      }

      for (int i = 0; i < al.get(index).size(); ++i) {
        int next = al.get(index).get(i).vertex;
        int nextValue = al.get(index).get(i).weight;

        if (nextValue + cost[index] < cost[next]) {
          cost[next] = nextValue + cost[index];
          pq.add(new Node(next, cost[next]));
        }
      }
    }

    bw.write(cost[end] + "\n");
    bw.close();
  }

  public static class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }
  }
}