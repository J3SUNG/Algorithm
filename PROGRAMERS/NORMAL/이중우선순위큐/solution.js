class Heap {
  constructor(dir) {
    this.index = 0;
    this.arr = [];
    this.dir = dir;
    this.deleted = new Set();
  }

  push(value) {
    this.arr.push({ value, index: this.index++ });
    if (this.arr.length > 1) {
      this.bubbleUp();
    }
  }

  bubbleUp() {
    let current = this.arr.length - 1;
    while (current > 0) {
      let parent = Math.floor((current - 1) / 2);

      if (
        (this.dir === 0 && this.arr[parent].value > this.arr[current].value) ||
        (this.dir === 1 && this.arr[parent].value < this.arr[current].value)
      ) {
        this.swap(parent, current);
        current = parent;
      } else {
        break;
      }
    }
  }

  pop() {
    while (this.arr.length > 0 && this.deleted.has(this.arr[0].index)) {
      this.swap(0, this.arr.length - 1);
      this.arr.pop();
      this.bubbleDown();
    }

    if (this.arr.length === 0) {
      return null;
    }

    const value = this.arr[0];
    this.swap(0, this.arr.length - 1);
    this.arr.pop();
    this.bubbleDown();
    return value;
  }

  bubbleDown() {
    let current = 0;

    while (true) {
      let leftChild = current * 2 + 1;
      let rightChild = current * 2 + 2;
      let swapIndex = null;

      if (leftChild >= this.arr.length) {
        break;
      }

      if (rightChild < this.arr.length) {
        if (
          (this.dir === 0 && this.arr[leftChild].value < this.arr[rightChild].value) ||
          (this.dir === 1 && this.arr[leftChild].value >= this.arr[rightChild].value)
        ) {
          swapIndex = leftChild;
        } else {
          swapIndex = rightChild;
        }
      } else {
        swapIndex = leftChild;
      }

      if (
        (this.dir === 0 && this.arr[current].value > this.arr[swapIndex].value) ||
        (this.dir === 1 && this.arr[current].value < this.arr[swapIndex].value)
      ) {
        this.swap(current, swapIndex);
        current = swapIndex;
      } else {
        break;
      }
    }
  }

  swap(a, b) {
    [this.arr[a], this.arr[b]] = [this.arr[b], this.arr[a]];
  }

  markAsDeleted(index) {
    this.deleted.add(index);
  }
}

function solution(operations) {
  let minPQ = new Heap(0);
  let maxPQ = new Heap(1);
  [];

  operations.forEach((item) => {
    const element = item.split(" ");
    if (element[0] === "I") {
      minPQ.push(parseInt(element[1]));
      maxPQ.push(parseInt(element[1]));
    } else if (element[0] === "D") {
      let popData;
      if (element[1] === "1") {
        popData = maxPQ.pop();
        if (popData) {
          minPQ.markAsDeleted(popData.index);
        }
      } else if (element[1] === "-1") {
        popData = minPQ.pop();
        if (popData) {
          maxPQ.markAsDeleted(popData.index);
        }
      }
    }
  });

  if (minPQ.arr.length === 0 || maxPQ.arr.length === 0) {
    return [0, 0];
  }

  const max = maxPQ.pop().value;
  const min = minPQ.pop().value;

  return [max, min];
}
