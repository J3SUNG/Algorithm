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
    const node = new Node(value);

    if (this.size === 0) {
      this.rear = node;
      this.front = node;
    } else {
      this.rear.next = node;
      this.rear = node;
    }

    ++this.size;
  }

  pop() {
    if (this.size === 0) {
      return null;
    }

    const value = this.front.value;

    --this.size;

    this.front = this.front.next;
    if (this.size === 0) {
      this.rear = null;
    }

    return value;
  }
}

function rotate(board, d) {
  let map = [];
  let yLen = board.length - 1;
  let xLen = board[0].length - 1;

  if (d === 0) {
    for (let i = 0; i <= yLen; ++i) {
      let temp = [];
      for (let j = 0; j <= xLen; ++j) {
        temp.push(board[i][j]);
      }
      map.push(temp);
    }
  } else if (d === 1) {
    for (let i = xLen; i >= 0; --i) {
      let temp = [];
      for (let j = 0; j <= yLen; ++j) {
        temp.push(board[j][i]);
      }
      map.push(temp);
    }
  } else if (d === 2) {
    for (let i = yLen; i >= 0; --i) {
      let temp = [];
      for (let j = xLen; j >= 0; --j) {
        temp.push(board[i][j]);
      }
      map.push(temp);
    }
  } else if (d === 3) {
    for (let i = 0; i <= xLen; ++i) {
      let temp = [];
      for (let j = yLen; j >= 0; --j) {
        temp.push(board[j][i]);
      }
      map.push(temp);
    }
  }

  return map;
}

function filterMap(board, x1, x2, y1, y2, num) {
  return board
    .slice(y1, y2 + 1)
    .map((row) => row.slice(x1, x2 + 1).map((item) => (item === num ? 1 : 0)));
}

function isValidRange(y, x, size) {
  return y >= 0 && x >= 0 && y < size && x < size;
}

function countSize(str) {
  return str.split("").filter((char) => char === "1").length;
}

function getShape(q, index, boardSize, board) {
  const moveY = [0, 1, 0, -1];
  const moveX = [1, 0, -1, 0];
  let xMin = boardSize;
  let xMax = 0;
  let yMin = boardSize;
  let yMax = 0;

  while (q.size > 0) {
    const [y, x] = q.pop();

    board[y][x] = index;
    yMin = Math.min(yMin, y);
    yMax = Math.max(yMax, y);
    xMin = Math.min(xMin, x);
    xMax = Math.max(xMax, x);

    for (let i = 0; i < 4; ++i) {
      const nextY = y + moveY[i];
      const nextX = x + moveX[i];

      if (isValidRange(nextY, nextX, boardSize) && board[nextY][nextX] === 0) {
        q.push([nextY, nextX]);
        board[nextY][nextX] = index;
      }
    }
  }

  return filterMap(board, xMin, xMax, yMin, yMax, index);
}

function solution(game_board, table) {
  let answer = 0;
  const q = new Queue();
  const map = new Map();
  const boardSize = game_board.length;
  let index = 2;
  table = table.map((row) => row.map((item) => (item ? 0 : 1)));

  for (let i = 0; i < boardSize; ++i) {
    for (let j = 0; j < boardSize; ++j) {
      if (game_board[i][j] === 0) {
        q.push([i, j]);
        const shape = getShape(q, index, boardSize, game_board);
        const key = JSON.stringify(shape);
        map.set(key, map.has(key) ? map.get(key) + 1 : 1);
        ++index;
      }
    }
  }

  for (let i = 0; i < boardSize; ++i) {
    for (let j = 0; j < boardSize; ++j) {
      if (table[i][j] === 0) {
        q.push([i, j]);
        const shape = getShape(q, index, boardSize, table);

        for (let k = 0; k < 4; ++k) {
          const rotatedShape = rotate(shape, k);
          const key = JSON.stringify(rotatedShape);

          if (map.has(key)) {
            answer += countSize(key);
            if (map.get(key) === 1) {
              map.delete(key);
            } else {
              map.set(key, map.get(key) - 1);
            }
            break;
          }

          ++index;
        }
      }
    }
  }

  return answer;
}
