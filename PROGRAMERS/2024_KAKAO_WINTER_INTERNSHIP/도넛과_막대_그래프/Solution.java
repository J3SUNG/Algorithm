import java.util.*;

class Solution {
  public int[] solution(int[][] edges) {
    int MAX_SIZE = 1000001;
    int[] answer = { 0, 0, 0, 0 };
    int[] inOut = new int[MAX_SIZE];
    ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    int start = 0;

    for (int i = 0; i < MAX_SIZE; ++i) {
      ArrayList<Integer> temp = new ArrayList<>();
      al.add(temp);
    }

    for (int i = 0; i < edges.length; ++i) {
      al.get(edges[i][0]).add(edges[i][1]);
      ++inOut[edges[i][0]];
      --inOut[edges[i][1]];
    }

    for (int i = 0; i < inOut.length; ++i) {
      if (inOut[i] >= 2) {
        start = i;
        answer[0] = start;
        break;
      }
    }

    for (int i = 0; i < al.get(start).size(); ++i) {
      int s = al.get(start).get(i);
      int next = s;

      while (true) {
        if (al.get(next).size() == 0) {
          ++answer[2];
          break;
        } else if (al.get(next).size() == 2) {
          ++answer[3];
          break;
        } else {
          next = al.get(next).get(0);
        }
        if (s == next) {
          ++answer[1];
          break;
        }
      }
    }

    return answer;
  }
}