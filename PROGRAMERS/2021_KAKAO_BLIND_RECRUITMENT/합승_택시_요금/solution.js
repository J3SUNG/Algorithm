function solution(n, s, a, b, fares) {
  const MAX = 1e9;
  const map = Array.from({ length: n + 1 }, () => new Array(n + 1).fill(MAX));
  let answer = MAX;

  for (let i = 1; i <= n; ++i) {
    map[i][i] = 0;
  }

  for (const [u, v, cost] of fares) {
    map[u][v] = cost;
    map[v][u] = cost;
  }

  for (let k = 1; k <= n; ++k) {
    for (let i = 1; i <= n; ++i) {
      for (let j = 1; j <= n; ++j) {
        if (map[i][k] + map[k][j] < map[i][j]) map[i][j] = map[i][k] + map[k][j];
      }
    }
  }

  for (let i = 1; i <= n; ++i) {
    answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
  }

  return answer;
}
