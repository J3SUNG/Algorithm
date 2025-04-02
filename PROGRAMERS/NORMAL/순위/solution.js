function solution(n, results) {
  const graph = Array.from({ length: n + 1 }, () => new Array(n + 1).fill(false));
  let answer = 0;

  for (const [winner, loser] of results) {
    graph[winner][loser] = true;
  }

  for (let k = 1; k <= n; ++k) {
    for (let i = 1; i <= n; ++i) {
      for (let j = 1; j <= n; ++j) {
        if (graph[i][k] && graph[k][j]) graph[i][j] = true;
      }
    }
  }

  for (let i = 1; i <= n; ++i) {
    let winCount = 0;
    let loseCount = 0;
    for (let j = 1; j <= n; ++j) {
      if (graph[i][j]) ++winCount;
      if (graph[j][i]) ++loseCount;
    }

    if (winCount + loseCount === n - 1) ++answer;
  }

  return answer;
}
