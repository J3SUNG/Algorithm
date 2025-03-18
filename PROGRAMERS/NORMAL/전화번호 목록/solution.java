import java.util.*;

class Pair {
  String first;
  int second;

  public Pair(String first, int second) {
    this.first = first;
    this.second = second;
  }
}

class Solution {
  public boolean solution(String[] phone_book) {
    boolean answer = true;
    Queue<Pair> q = new LinkedList<>();
    Set<String> set = new HashSet<>();

    Arrays.sort(phone_book, (a, b) -> a.length() - b.length());

    for (int i = 0; i < phone_book.length; ++i) {
      q.add(new Pair(phone_book[i], 1));
    }

    while (!q.isEmpty()) {
      Pair p = q.poll();
      int size = p.first.length();

      if (set.contains(p.first.substring(0, p.second))) {
        answer = false;
        break;
      }

      if (p.second == size) {
        set.add(p.first);
      } else {
        q.add(new Pair(p.first, p.second + 1));
      }
    }

    return answer;
  }
}