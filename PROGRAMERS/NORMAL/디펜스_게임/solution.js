class MaxHeap {
  constructor() {
    this.heap = [];
  }

  swap(i, j) {
    [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
  }

  push(value) {
    this.heap.push(value);
    this.heapifyUp();
  }

  pop() {
    if (this.heap.length === 1) return this.heap.pop();
    const max = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.heapifyDown();
    return max;
  }

  heapifyUp() {
    let index = this.heap.length - 1;
    while (index > 0) {
      let parentIndex = Math.floor((index - 1) / 2);
      if (this.heap[parentIndex] >= this.heap[index]) break;
      this.swap(parentIndex, index);
      index = parentIndex;
    }
  }

  heapifyDown() {
    let index = 0;
    let length = this.heap.length;

    while (true) {
      let leftChild = 2 * index + 1;
      let rightChild = 2 * index + 2;
      let largest = index;

      if (leftChild < length && this.heap[leftChild] > this.heap[largest]) {
        largest = leftChild;
      }

      if (rightChild < length && this.heap[rightChild] > this.heap[largest]) {
        largest = rightChild;
      }

      if (largest === index) break;
      this.swap(index, largest);
      index = largest;
    }
  }

  isEmpty() {
    return this.heap.length === 0;
  }
}

class PriorityQueue {
  constructor() {
    this.maxHeap = new MaxHeap();
  }

  enqueue(value) {
    this.maxHeap.push(value);
  }

  dequeue() {
    return this.maxHeap.pop();
  }

  isEmpty() {
    return this.maxHeap.isEmpty();
  }
}

function solution(n, k, enemy) {
  let answer = 0;
  const pq = new PriorityQueue();
  let sum = 0;

  for (let i = 0; i < enemy.length; ++i) {
    sum += enemy[i];
    pq.enqueue(enemy[i]);

    if (sum > n) {
      if (k <= 0) break;

      sum -= pq.dequeue();
      --k;
    }

    ++answer;
  }

  return answer;
}
