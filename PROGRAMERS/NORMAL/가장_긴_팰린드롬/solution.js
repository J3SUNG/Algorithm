function solution(s) {
  const n = s.length;
  const memo = Array.from({ length: n }, () => new Array(n).fill(false));
  let answer = 1;

  for (let i = 0; i < n; i++) memo[i][i] = true;

  for (let i = 0; i < n - 1; i++) {
    if (s[i] === s[i + 1]) {
      memo[i][i + 1] = true;
      answer = 2;
    }
  }

  for (let len = 3; len <= n; len++) {
    for (let i = 0; i <= n - len; i++) {
      const j = i + len - 1;
      if (s[i] === s[j] && memo[i + 1][j - 1]) {
        memo[i][j] = true;
        answer = len;
      }
    }
  }

  return answer;
}
