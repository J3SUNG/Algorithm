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
      this.rear = node;
    } else {
      this.rear.next = node;
      this.rear = node;
    }

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

function solution(begin, target, words) {
  const size = begin.length;
  let answer = 0;
  let q = new Queue();
  let visit = new Set();

  q.enqueue([begin, 0]);

  while (q.size > 0) {
    const [curWord, count] = q.dequeue();

    for (const word of words) {
      if (visit.has(word)) continue;

      let diff = 0;
      for (let i = 0; i < size; ++i) {
        if (curWord[i] !== word[i]) ++diff;
        if (diff > 1) break;
      }

      if (diff === 1) {
        if (word === target) return count + 1;

        visit.add(word, count + 1);
        q.enqueue([word, count + 1]);
      }
    }
  }

  return answer;
}
