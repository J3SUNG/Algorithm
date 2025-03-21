class MaxHeap {
  constructor() {
    this.heap = [];
  }

  push(value) {
    this.heap.push(value);
    let i = this.heap.length - 1;
    while (i > 0) {
      let p = Math.floor((i - 1) / 2);
      if (this.heap[p] >= this.heap[i]) break;
      [this.heap[i], this.heap[p]] = [this.heap[p], this.heap[i]];
      i = p;
    }
  }

  pop() {
    if (this.heap.length === 0) return 0;
    const top = this.heap[0];
    const last = this.heap.pop();
    if (this.heap.length === 0) return top;
    this.heap[0] = last;
    let i = 0;
    const n = this.heap.length;
    while (true) {
      let left = 2 * i + 1,
        right = 2 * i + 2,
        largest = i;
      if (left < n && this.heap[left] > this.heap[largest]) largest = left;
      if (right < n && this.heap[right] > this.heap[largest]) largest = right;
      if (largest === i) break;
      [this.heap[i], this.heap[largest]] = [this.heap[largest], this.heap[i]];
      i = largest;
    }
    return top;
  }
}

function solution(n, works) {
  let answer = 0;
  const pq = new MaxHeap();

  for (const work of works) {
    pq.push(work);
  }

  while (n > 0) {
    let work = pq.pop();

    --work;
    --n;
    pq.push(work);
  }

  while (pq.heap.length > 0) {
    const work = pq.pop();

    answer += work <= 0 ? 0 : work ** 2;
  }

  return answer;
}
