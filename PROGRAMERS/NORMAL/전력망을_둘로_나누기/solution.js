function dfs(index, cutWire, dist, visit) {
  let cnt = 1;

  for (const next of dist[index]) {
    if (
      visit[next] ||
      (cutWire[0] === index && cutWire[1] === next) ||
      (cutWire[1] === index && cutWire[0] === next)
    ) {
      continue;
    }

    visit[next] = true;
    cnt += dfs(next, cutWire, dist, visit);
  }

  return cnt;
}

function solution(n, wires) {
  let answer = n;
  let dist = Array.from({ length: n + 1 }, () => []);
  let visit = new Array(n + 1);

  for (const [a, b] of wires) {
    dist[a].push(b);
    dist[b].push(a);
  }

  for (const [a, b] of wires) {
    visit.fill(false);
    visit[a] = true;

    const num = dfs(a, [a, b], dist, visit);
    answer = Math.min(answer, Math.abs(n - num - num));
  }

  return answer;
}
