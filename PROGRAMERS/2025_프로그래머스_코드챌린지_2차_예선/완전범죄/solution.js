class MinHeap {
  constructor() {
    this.heap = [];
  }

  getParentIndex(i) {
    return Math.floor((i - 1) / 2);
  }
  getLeftChildIndex(i) {
    return 2 * i + 1;
  }
  getRightChildIndex(i) {
    return 2 * i + 2;
  }

  swap(i, j) {
    [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
  }

  push(value, priority) {
    this.heap.push({ value, priority });
    this.heapifyUp();
  }

  pop() {
    if (this.heap.length === 1) return this.heap.pop();
    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.heapifyDown();
    return min;
  }

  heapifyUp() {
    let index = this.heap.length - 1;
    while (
      index > 0 &&
      this.heap[this.getParentIndex(index)].priority > this.heap[index].priority
    ) {
      this.swap(index, this.getParentIndex(index));
      index = this.getParentIndex(index);
    }
  }

  heapifyDown() {
    let index = 0;
    while (this.getLeftChildIndex(index) < this.heap.length) {
      let smallerChildIndex = this.getLeftChildIndex(index);
      let rightChildIndex = this.getRightChildIndex(index);

      if (
        rightChildIndex < this.heap.length &&
        this.heap[rightChildIndex].priority < this.heap[smallerChildIndex].priority
      ) {
        smallerChildIndex = rightChildIndex;
      }

      if (this.heap[index].priority < this.heap[smallerChildIndex].priority) break;

      this.swap(index, smallerChildIndex);
      index = smallerChildIndex;
    }
  }

  isEmpty() {
    return this.heap.length === 0;
  }
}

class PriorityQueue {
  constructor() {
    this.minHeap = new MinHeap();
  }

  enqueue(value, priority) {
    this.minHeap.push(value, priority);
  }

  dequeue() {
    return this.minHeap.pop();
  }

  peek() {
    return this.minHeap.heap.length ? this.minHeap.heap[0] : null;
  }

  isEmpty() {
    return this.minHeap.isEmpty();
  }
}

function solution(info, n, m) {
  const pq = new PriorityQueue();
  const size = info.length;
  const MAX_VALUE = Number.MAX_VALUE;
  const visit = Array.from({ length: n + 1 }, () =>
    Array.from({ length: m + 1 }, () => Array(size).fill(false))
  );
  let answer = MAX_VALUE;

  pq.enqueue([0, 0, 0], 0);

  while (!pq.isEmpty()) {
    const {
      value: [a, b, i],
    } = pq.dequeue();

    if (i === size) {
      answer = Math.min(answer, a);
      continue;
    }

    if (visit[a][b][i]) continue;
    visit[a][b][i] = true;

    const [nextA, nextB] = info[i];

    if (a + nextA < n) {
      pq.enqueue([a + nextA, b, i + 1], a + nextA);
    }

    if (b + nextB < m) {
      pq.enqueue([a, b + nextB, i + 1], a);
    }
  }

  return answer === MAX_VALUE ? -1 : answer;
}
