class Queue {
  constructor() {
    this.queue = [];
    this.frontIndex = 0;
  }

  enqueue(value) {
    this.queue.push(value);
  }

  dequeue() {
    if (this.queue.length === this.frontIndex) return null;
    return this.queue[this.frontIndex++];
  }

  isEmpty() {
    return this.queue.length === this.frontIndex;
  }
}

function solution(maps) {
  const rows = maps.length;
  const cols = maps[0].length;
  const visit = Array.from({ length: rows }, () =>
    Array.from({ length: cols }, () => [Infinity, Infinity])
  );
  const q = new Queue();
  const my = [0, 1, 0, -1];
  const mx = [1, 0, -1, 0];
  let answer = -1;
  let ey, ex, ly, lx;

  for (let i = 0; i < rows; ++i) {
    for (let j = 0; j < cols; ++j) {
      if (maps[i][j] === "O" || maps[i][j] === "X") {
        continue;
      } else if (maps[i][j] === "S") {
        q.enqueue({ y: i, x: j, lever: 0, time: 0 });
        visit[i][j][0] = 0;
      } else if (maps[i][j] === "E") {
        ey = i;
        ex = j;
      } else if (maps[i][j] === "L") {
        ly = i;
        lx = j;
      }
    }
  }

  while (!q.isEmpty()) {
    let { x, y, lever, time } = q.dequeue();

    if (y === ly && x === lx && time < visit[y][x][1]) {
      visit[y][x][1] = time;
      lever = 1;
    }

    if (y === ey && x === ex && lever === 1) {
      answer = time;
      break;
    }

    for (let i = 0; i < 4; ++i) {
      const nextY = y + my[i];
      const nextX = x + mx[i];
      const nextTime = time + 1;

      if (
        nextY < 0 ||
        nextX < 0 ||
        nextY >= rows ||
        nextX >= cols ||
        maps[nextY][nextX] === "X" ||
        nextTime >= visit[nextY][nextX][lever]
      ) {
        continue;
      }

      q.enqueue({ x: nextX, y: nextY, lever, time: nextTime });
      visit[nextY][nextX][lever] = nextTime;
    }
  }

  return answer;
}
