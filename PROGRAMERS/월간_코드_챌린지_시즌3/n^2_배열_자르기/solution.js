function solution(n, left, right) {
  let answer = [];

  for (let i = left; i <= right; ++i) {
    const y = Math.floor(i / n);
    const x = i % n;

    answer.push(Math.max(x, y) + 1);
  }

  return answer;
}
