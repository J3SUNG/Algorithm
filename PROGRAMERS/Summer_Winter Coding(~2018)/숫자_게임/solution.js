function solution(A, B) {
  A.sort((a, b) => a - b);
  B.sort((a, b) => a - b);

  let wins = 0;
  let index = 0;

  for (const num of B) {
    if (A[index] < num) {
      ++wins;
      ++index;
    }
  }

  return wins;
}
