class Heap {
  constructor() {
    this.arr = [];
  }

  push(index, value) {
    this.arr.push({ index, value });
    this.bubbleUp();
  }

  pop() {
    if (this.arr.length === 0) {
      return null;
    }

    const object = this.arr[0];

    if (this.arr.length === 1) {
      this.arr.pop();
    } else {
      this.arr[0] = this.arr.pop();
      this.bubbleDown();
    }

    return object;
  }

  bubbleUp() {
    let current = this.arr.length - 1;

    while (current > 0) {
      let parent = Math.floor((current - 1) / 2);
      if (this.arr[current].value < this.arr[parent].value) {
        this.swap(current, parent);
        current = parent;
      } else {
        break;
      }
    }
  }

  bubbleDown() {
    let current = 0;
    let length = this.arr.length;

    while (true) {
      let childLeft = current * 2 + 1;
      let childRight = current * 2 + 2;
      let swapIndex = null;

      if (childLeft < length) {
        if (this.arr[childLeft].value < this.arr[current].value) {
          swapIndex = childLeft;
        }
      }

      if (childRight < length) {
        if (
          (swapIndex === null && this.arr[childRight].value < this.arr[current].value) ||
          (swapIndex !== null && this.arr[childRight].value < this.arr[swapIndex].value)
        ) {
          swapIndex = childRight;
        }
      }

      if (swapIndex === null) {
        break;
      }

      this.swap(current, swapIndex);
      current = swapIndex;
    }
  }

  size() {
    return this.arr.length;
  }

  isEmpty() {
    return this.arr.length === 0;
  }

  swap(a, b) {
    return ([this.arr[a], this.arr[b]] = [this.arr[b], this.arr[a]]);
  }
}

function solution(N, road, K) {
  const MAX_VALUE = 987654321;
  let answer = 0;
  let map = Array.from({ length: N + 1 }, () => []);
  let dist = Array.from({ length: N + 1 }, () => MAX_VALUE);
  let visit = Array.from({ length: N + 1 }, () => false);
  let pq = new Heap();

  road.forEach((item) => {
    map[item[0]].push({ index: item[1], value: item[2] });
    map[item[1]].push({ index: item[0], value: item[2] });
  });

  pq.push(1, 0);
  dist[1] = 0;

  let test = 0;
  while (!pq.isEmpty()) {
    if (test++ === 1115) {
      break;
    }
    let { index, value } = pq.pop();

    if (visit[index] || dist[index] < value) {
      continue;
    }

    visit[index] = true;

    map[index].forEach((item) => {
      if (!visit[item.index]) {
        let sumValue = value + item.value;
        if (dist[item.index] > sumValue) {
          dist[item.index] = sumValue;
          pq.push(item.index, sumValue);
        }
      }
    });
  }

  dist.forEach((item) => {
    if (item <= K) {
      ++answer;
    }
  });

  return answer;
}
