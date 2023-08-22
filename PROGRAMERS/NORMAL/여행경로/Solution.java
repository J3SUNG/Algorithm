import java.util.*;

class Solution {
  static ArrayList<ArrayList<Integer>> al;
  static boolean[][] visit;
  static int size;
  static ArrayList<Integer> result;

  public String[] solution(String[][] tickets) {
    al = new ArrayList<>();
    visit = new boolean[19684][10001];
    size = tickets.length;
    result = new ArrayList<>();
    String[] answer = new String[tickets.length + 1];
    boolean chk = false;

    for (int i = 0; i < 19684; ++i) {
      ArrayList<Integer> temp = new ArrayList<>();
      al.add(temp);
    }

    for (int i = 0; i < tickets.length; ++i) {
      int index = ConverterToInt(tickets[i][0]);
      al.get(index).add(ConverterToInt(tickets[i][1]));
    }

    for (int i = 0; i < al.size(); ++i) {
      Collections.sort(al.get(i));
    }

    for (int i = 0; i < al.get(6656).size(); ++i) {
      visit[6656][i] = true;
      if (DFS(al.get(6656).get(i), 1)) {
        result.add(6656);
        chk = true;
        break;
      }
      visit[6656][i] = false;
    }

    for (int i = 0; i < tickets.length + 1; ++i) {
      answer[i] = ConverterToString(result.get(tickets.length - i));
    }

    return answer;
  }

  public static boolean DFS(int num, int cnt) {
    if (cnt == size) {
      result.add(num);
      return true;
    }
    for (int i = 0; i < al.get(num).size(); ++i) {
      if (!visit[num][i]) {
        visit[num][i] = true;
        if (DFS(al.get(num).get(i), cnt + 1)) {
          result.add(num);
          return true;
        }
        visit[num][i] = false;
      }
    }
    return false;
  }

  public static int ConverterToInt(String s) {
    int num1 = s.charAt(0) - 'A' + 1;
    int num2 = s.charAt(1) - 'A' + 1;
    int num3 = s.charAt(2) - 'A' + 1;

    num1 *= 27 * 27;
    num2 *= 27;

    return num1 + num2 + num3;
  }

  public static String ConverterToString(int num) {
    char char3 = (char) ((num % 27) + 'A' - 1);
    num /= 27;
    char char2 = (char) ((num % 27) + 'A' - 1);
    num /= 27;
    char char1 = (char) ((num % 27) + 'A' - 1);

    String s = Character.toString(char1) + Character.toString(char2) + Character.toString(char3);
    return s;
  }
}
