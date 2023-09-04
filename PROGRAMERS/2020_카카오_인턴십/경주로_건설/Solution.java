import java.util.*;

class Solution {
  public static int solution(int[][] board) {
    int answer = 0;
    int[][][] visit = new int[board.length][board[0].length][2];
    int[] my = { 0, 1, 0, -1 };
    int[] mx = { 1, 0, -1, 0 };
    Queue<Data> q = new LinkedList<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        visit[i][j][0] = 987654321;
        visit[i][j][1] = 987654321;
      }
    }

    visit[0][0][0] = 0;
    visit[0][0][1] = 0;
    q.add(new Data(0, 0, 0));
    q.add(new Data(0, 0, 1));
    while (!q.isEmpty()) {
      Data data = q.poll();
      int y = data.y;
      int x = data.x;
      int d = data.d;

      for (int i = 0; i < 4; ++i) {
        int ny = y + my[i];
        int nx = x + mx[i];

        if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[ny].length || board[ny][nx] == 1) {
          continue;
        }

        if ((d == 0 && i % 2 == 0) || (d == 1 && i % 2 != 0)) {
          if (visit[ny][nx][(d + 1) % 2] > visit[y][x][d] + 600) {
            visit[ny][nx][(d + 1) % 2] = visit[y][x][d] + 600;
            q.add(new Data(ny, nx, (d + 1) % 2));
          }
        } else {
          if (visit[ny][nx][d] > visit[y][x][d] + 100) {
            visit[ny][nx][d] = visit[y][x][d] + 100;
            q.add(new Data(ny, nx, d));
          }
        }
      }
    }

    answer = Math.min(visit[board.length - 1][board[0].length - 1][0], visit[board.length - 1][board[0].length - 1][1]);

    return answer;
  }

  public static class Data {
    int x;
    int y;
    int d;

    Data(int y, int x, int d) {
      this.y = y;
      this.x = x;
      this.d = d;
    }
  }
}