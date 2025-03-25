class minHeap {
  constructor() {
    this.heap = [];
  }

  push(v) {
    this.heap.push(v);

    let i = this.heap.length - 1;
    while (i > 0) {
      const p = Math.floor((i - 1) / 2);
      if (this.heap[i].value >= this.heap[p].value) break;
      [this.heap[i], this.heap[p]] = [this.heap[p], this.heap[i]];
      i = p;
    }
  }

  pop() {
    if (this.heap.length === 0) return null;
    if (this.heap.length === 1) return this.heap.pop();

    const top = this.heap[0];
    this.heap[0] = this.heap.pop();

    const n = this.heap.length;
    let i = 0;
    while (true) {
      const l = i * 2 + 1;
      const r = i * 2 + 2;
      let min = i;

      if (l < n && this.heap[min].value > this.heap[l].value) min = l;
      if (r < n && this.heap[min].value > this.heap[r].value) min = r;
      if (min === i) break;

      [this.heap[i], this.heap[min]] = [this.heap[min], this.heap[i]];
      i = min;
    }

    return top;
  }

  size() {
    return this.heap.length;
  }
  isEmpty() {
    return this.heap.length === 0;
  }
}

function solution(n, costs) {
  let answer = 0;
  const pq = new minHeap();
  const visited = new Array(n).fill(false);
  const graph = Array.from({ length: n }, () => []);

  for (const [a, b, cost] of costs) {
    graph[a].push({ node: b, value: cost });
    graph[b].push({ node: a, value: cost });
  }

  pq.push({ node: 0, value: 0 });

  while (pq.heap.length > 0) {
    const { node, value } = pq.pop();
    if (visited[node]) continue;
    visited[node] = true;
    answer += value;

    for (const next of graph[node]) {
      if (!visited[next.node]) {
        pq.push(next);
      }
    }
  }

  return answer;
}
