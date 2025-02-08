function solution(e, starts) {
  const countArr = new Array(e + 1).fill(0);
  for (let i = 1; i <= e; i++) {
    for (let j = i; j <= e; j += i) {
      countArr[j]++;
    }
  }

  const best = new Array(e + 1);
  best[e] = e;
  for (let i = e - 1; i >= 1; i--) {
    best[i] = countArr[i] >= countArr[best[i + 1]] ? i : best[i + 1];
  }

  const answer = new Array(starts.length);
  for (let i = 0; i < starts.length; i++) {
    answer[i] = best[starts[i]];
  }
  return answer;
}
