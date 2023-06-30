import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int size;
    ArrayList<ArrayList<Integer>> al;
    int[] visit;

    while (true) {
      st = new StringTokenizer(br.readLine());
      size = Integer.parseInt(st.nextToken());
      al = new ArrayList<>();
      visit = new int[size + 1];

      if (size == 0) {
        break;
      }

      for (int i = 0; i <= size; ++i) {
        ArrayList<Integer> temp = new ArrayList<>();
        al.add(temp);
        visit[i] = -1;
      }

      for (int i = 1; i <= size; ++i) {
        st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int type = s.equals("E") ? 0 : s.equals("L") ? 1 : 2;
        int value = Integer.parseInt(st.nextToken());
        al.get(i).add(type);
        al.get(i).add(value);
        while (true) {
          int next = Integer.parseInt(st.nextToken());
          if (next == 0) {
            break;
          }

          al.get(i).add(next);
        }
      }

      Queue<Pair> q = new LinkedList<>();
      String result = "No";

      if (al.get(1).get(0) != 2) {
        q.add(new Pair(1, al.get(1).get(1)));
      }
      while (!q.isEmpty()) {
        int index = q.peek().index;
        int money = q.peek().money;
        q.poll();

        for (int i = 2; i < al.get(index).size(); ++i) {
          int next = al.get(index).get(i);
          int type = al.get(next).get(0);
          int value = al.get(next).get(1);

          int nextMoney = 0;
          if (type == 1) {
            nextMoney = Math.max(money, value);
          } else {
            nextMoney = money - value;
          }

          if (visit[next] >= nextMoney || nextMoney < 0) {
            continue;
          }

          if (next == size) {
            result = "Yes";
            while (!q.isEmpty()) {
              q.poll();
            }
            break;
          }

          visit[next] = nextMoney;
          q.add(new Pair(next, nextMoney));
        }
      }
      bw.write(result + "\n");
    }
    bw.close();
  }

  static public class Pair {
    int index;
    int money;

    public Pair(int index, int money) {
      this.index = index;
      this.money = money;
    }
  }
}