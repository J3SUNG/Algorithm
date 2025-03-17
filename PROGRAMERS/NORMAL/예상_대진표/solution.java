class Solution {
  public int solution(int n, int a, int b) {
      int cnt = 1;
      
      --a;
      --b;

      while (a / 2 != b / 2) {
          a /= 2;
          b /= 2;
          cnt++;
      }

      return cnt;
  }
}
