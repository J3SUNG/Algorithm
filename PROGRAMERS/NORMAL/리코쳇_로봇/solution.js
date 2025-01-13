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
    const newNode = new Node(value);

    if (this.size === 0) {
      this.front = newNode;
      this.rear = newNode;
    } else {
      this.rear.next = newNode;
      this.rear = newNode;
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

function solution(board) {
  let dp = [];
  const q = new Queue();
  const newBoard = board.map((item) => item.split(""));
  const moveY = [0, 1, 0, -1];
  const moveX = [1, 0, -1, 0];

  for (let i = 0; i < newBoard.length; ++i) {
    const temp = [];
    for (let j = 0; j < newBoard[0].length; ++j) {
      if (newBoard[i][j] === "R") {
        q.push({ y: i, x: j, c: 0 });
        temp.push(0);
      } else {
        temp.push(Infinity);
      }
    }
    dp.push(temp);
  }

  while (q.size > 0) {
    const { y, x, c } = q.pop();

    for (let i = 0; i < 4; ++i) {
      let cy = y;
      let cx = x;

      while (
        cy + moveY[i] >= 0 &&
        cx + moveX[i] >= 0 &&
        cy + moveY[i] < newBoard.length &&
        cx + moveX[i] < newBoard[0].length &&
        newBoard[cy + moveY[i]][cx + moveX[i]] !== "D"
      ) {
        cy += moveY[i];
        cx += moveX[i];
      }

      if (newBoard[cy][cx] === "G") {
        return c + 1;
      }

      if (c + 1 < dp[cy][cx]) {
        dp[cy][cx] = c + 1;
        q.push({ y: cy, x: cx, c: c + 1 });
      }
    }
  }

  return -1;
}
