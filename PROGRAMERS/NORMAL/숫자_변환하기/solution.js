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

  enqueue(value) {
    const node = new Node(value);

    if (this.size === 0) {
      this.front = node;
    } else {
      this.rear.next = node;
    }

    this.rear = node;
    ++this.size;
  }

  dequeue() {
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

function solution(x, y, n) {
  let q = new Queue();
  let visit = new Set();
  let count = 0;

  q.enqueue(x);
  visit.add(x);

  if (x === y) return 0;

  while (q.size > 0) {
    let size = q.size;
    for (let i = 0; i < size; ++i) {
      const num = q.dequeue();

      for (const next of [num + n, num * 2, num * 3]) {
        if (next === y) return count + 1;
        if (next < y && !visit.has(next)) {
          visit.add(next);
          q.enqueue(next);
        }
      }
    }

    ++count;
  }

  return -1;
}
