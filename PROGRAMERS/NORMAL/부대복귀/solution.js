class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  push(value) {
    const node = new Node(value);

    if (this.size === 0) {
      this.front = node;
      this.rear = node;
    } else {
      this.rear.next = node;
      this.rear = node;
    }

    ++this.size;
  }

  pop() {
    if (this.size === 0) {
      return null;
    }

    const value = this.front.value;
    this.front = this.front.next;
    --this.size;

    if (this.size === 0) {
      this.rear = null;
    }

    return value;
  }
}

function solution(n, roads, sources, destination) {
  let answer = [];
  let visit = new Array(n + 1).fill(-1);
  let dist = new Array(n + 1).fill(null).map(() => []);
  let q = new Queue();

  for ([a, b] of roads) {
    dist[a].push(b);
    dist[b].push(a);
  }

  q.push([destination, 0]);
  visit[destination] = 0;

  while (q.size > 0) {
    const [current, cost] = q.pop();

    for (const next of dist[current]) {
      if (visit[next] === -1) {
        visit[next] = cost + 1;
        q.push([next, cost + 1]);
      }
    }
  }

  for (const source of sources) {
    answer.push(visit[source]);
  }

  return answer;
}
