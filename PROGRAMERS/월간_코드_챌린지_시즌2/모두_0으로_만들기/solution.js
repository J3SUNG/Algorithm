function getRootNode(edges) {
  const node = new Array(edges.length + 1).fill(0);

  edges.forEach(([a, b]) => {
    ++node[a];
    ++node[b];
  });

  for (let i = 0; i < node.length; ++i) {
    if (node[i] === 1) {
      return i;
    }
  }
}

function getDist(edges) {
  const dist = Array.from({ length: edges.length + 1 }, () => []);

  edges.forEach(([a, b]) => {
    dist[a].push(b);
    dist[b].push(a);
  });

  return dist;
}

function dfs(start, dist, a) {
  const visit = Array(a.length).fill(false);
  const stack = [[start, null]];
  const order = [];

  while (stack.length) {
    const [node, parent] = stack.pop();

    if (visit[node]) continue;

    visit[node] = true;
    order.push([node, parent]);

    for (const index of dist[node]) {
      if (!visit[index]) stack.push([index, node]);
    }
  }

  const result = Array(a.length).fill(0n);
  const childCount = Array(a.length).fill(0n);

  for (let i = order.length - 1; i >= 0; i--) {
    const [node, parent] = order[i];
    let sum = 0n,
      cnt = 0n;
    for (const index of dist[node]) {
      if (index !== parent) {
        sum += result[index];
        cnt += childCount[index];
      }
    }
    result[node] = BigInt(a[node]) + sum;
    childCount[node] = BigInt(Math.abs(Number(result[node]))) + cnt;
  }

  return [result[start], childCount[start]];
}

function solution(a, edges) {
  const root = getRootNode(edges);
  const dist = getDist(edges);
  const [num, cnt] = dfs(root, dist, a);

  return num === 0n ? cnt : -1;
}
