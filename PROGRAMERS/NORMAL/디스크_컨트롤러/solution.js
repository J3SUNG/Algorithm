function compare(a, b) {
  return a[2] !== b[2] ? a[2] < b[2] : a[1] < b[1];
}

class minHeap {
  constructor() {
    this.heap = [];
  }

  push(v) {
    this.heap.push(v);
    let i = this.heap.length - 1;
    while (i > 0) {
      const p = Math.floor((i - 1) / 2);
      if (compare(this.heap[p], this.heap[i])) break;
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

      if (l < n && compare(this.heap[l], this.heap[min])) min = l;
      if (r < n && compare(this.heap[r], this.heap[min])) min = r;
      if (i === min) break;

      [this.heap[i], this.heap[min]] = [this.heap[min], this.heap[i]];
      i = min;
    }

    return top;
  }
  isSize() {
    return this.heap.length;
  }
  isEmpty() {
    return this.heap.length === 0;
  }
}

function solution(jobs) {
  let answer = 0;
  let time = 0;
  let i = 0;

  jobs.sort((a, b) => a[0] - b[0]);
  const pq = new minHeap();

  while (i < jobs.length || !pq.isEmpty()) {
    while (i < jobs.length && jobs[i][0] <= time) {
      pq.push([i, jobs[i][0], jobs[i][1]]);
      i++;
    }

    if (!pq.isEmpty()) {
      const [index, req, dur] = pq.pop();
      time += dur;
      answer += time - req;
    } else {
      time = jobs[i][0];
    }
  }

  return Math.floor(answer / jobs.length);
}
