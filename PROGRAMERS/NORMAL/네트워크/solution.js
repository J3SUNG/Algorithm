function solution(n, computers) {
  let answer = 0;
  let visit = new Array(n).fill(false);

  function dfs(index) {
    for (let i = 0; i < n; ++i) {
      if (computers[index][i] === 1 && !visit[i]) {
        visit[i] = true;
        dfs(i);
      }
    }
  }

  for (let i = 0; i < n; ++i) {
    if (visit[i]) {
      continue;
    }

    visit[i] = true;
    dfs(i);
    ++answer;
  }

  return answer;
}
