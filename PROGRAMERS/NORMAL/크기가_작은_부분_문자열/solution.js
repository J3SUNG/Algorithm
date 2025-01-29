function solution(t, p) {
  let answer = 0;
  const size = p.length;

  for (let i = 0; i <= t.length - size; ++i) {
    if (t.slice(i, i + size) <= p) {
      ++answer;
    }
  }

  return answer;
}
