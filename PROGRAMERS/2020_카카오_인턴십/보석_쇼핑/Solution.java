import java.util.*;

class Solution {

  public static void main(String[] args) {
    String[] gems = { "XYZ", "XYZ", "XYZ" };
    int[] result = solution(gems);
    System.out.println(result[0] + " " + result[1]);
  }

  public static int[] solution(String[] gems) {
    int[] answer = new int[2];
    int size = 0;
    int maxSize = 987654321;
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    for (int i = 0; i < gems.length; ++i) {
      if (map.get(gems[i]) == null) {
        ++size;
        map.put(gems[i], 0);
      }
    }

    int left = 0;
    int right = 0;
    int cnt = 0;
    while (left <= right && right < gems.length) {
      map.put(gems[right], map.get(gems[right]) + 1);
      if (map.get(gems[right]) == 1) {
        ++cnt;
      }

      if (cnt == size) {
        if (right - left < maxSize) {
          maxSize = right - left;
          answer[0] = left + 1;
          answer[1] = right + 1;
        }
        while (cnt == size && left < right) {
          if (right - left < maxSize) {
            maxSize = right - left;
            answer[0] = left + 1;
            answer[1] = right + 1;
          }
          map.put(gems[left], map.get(gems[left]) - 1);

          if (map.get(gems[left]) == 0) {
            --cnt;
          }

          ++left;
        }
      }
      ++right;
    }

    return answer;
  }
}