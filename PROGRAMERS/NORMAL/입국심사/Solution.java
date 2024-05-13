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
}