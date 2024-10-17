class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.front = null;
    this.tail = null;
    this.size = 0;
  }

  push(value) {
    const node = new Node(value);

    if (this.size === 0) {
      this.front = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
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
      this.tail = null;
    }

    return value;
  }
}

function solution(n, edge) {
  let answer = 0;
  let map = Array.from({ length: n + 1 }, () => []);
  let visit = new Array(n + 1).fill(false);
  const q = new Queue();

  q.push(1);
  visit[1] = true;

  edge.forEach((item) => {
    map[item[0]].push(item[1]);
    map[item[1]].push(item[0]);
  });

  let cnt = 1;
  let nextCnt = 0;

  while (q.size > 0) {
    const index = q.pop();

    for (let i = 0; i < map[index].length; ++i) {
      if (visit[map[index][i]]) {
        continue;
      }

      q.push(map[index][i]);
      ++nextCnt;
      visit[map[index][i]] = true;
    }
    --cnt;

    if (cnt === 0) {
      if (nextCnt > 0) {
        answer = nextCnt;
      }
      cnt = nextCnt;
      nextCnt = 0;
    }
  }

  return answer;
}
