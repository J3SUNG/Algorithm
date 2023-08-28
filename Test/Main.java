class Solution {
  public long solution(int n, int[] times) {
    long answer = 0;
    long start = 1;
    long end = 1_000_000_000L * 1_000_000_000L;
    while (start <= end) {
      long mid = (start + end) / 2;
      long temp = n;
      for (int i = 0; i < times.length; i++) {
        temp -= mid / times[i];
        if (temp <= 0) {
          break;
        }
      }
      if (temp <= 0) {
        end = mid - 1;
        answer = Math.min(answer, mid);
      } else {
        start = mid + 1;
      }
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