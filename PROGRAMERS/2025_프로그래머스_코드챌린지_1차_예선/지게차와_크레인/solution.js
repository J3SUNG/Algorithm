function solution(storage, requests) {
  const n = storage.length,
    m = storage[0].length;
  const grid = Array.from({ length: n + 2 }, (_, i) =>
    Array.from({ length: m + 2 }, (_, j) =>
      i === 0 || j === 0 || i === n + 1 || j === m + 1 ? -1 : storage[i - 1][j - 1]
    )
  );

  const moves = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];

  function updateExternal() {
    const rows = grid.length,
      cols = grid[0].length;
    const visited = Array.from({ length: rows }, () => Array(cols).fill(false));
    const queue = [[0, 0]];
    visited[0][0] = true;

    while (queue.length) {
      const [y, x] = queue.shift();
      for (const [dy, dx] of moves) {
        const ny = y + dy,
          nx = x + dx;
        if (ny < 0 || nx < 0 || ny >= rows || nx >= cols || visited[ny][nx]) continue;
        if (typeof grid[ny][nx] === "number") {
          grid[ny][nx] = -1;
          visited[ny][nx] = true;
          queue.push([ny, nx]);
        }
      }
    }
  }

  for (let idx = 0; idx < requests.length; idx++) {
    const req = requests[idx];
    const target = req[0];
    if (req.length === 1) {
      for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
          if (grid[i][j] !== target) continue;
          for (const [dy, dx] of moves) {
            if (grid[i + dy][j + dx] === -1) {
              grid[i][j] = idx;
              break;
            }
          }
        }
      }
    } else {
      for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
          if (grid[i][j] === target) grid[i][j] = Infinity;
        }
      }
    }
    updateExternal();
  }

  let answer = 0;
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= m; j++) {
      if (typeof grid[i][j] === "string") answer++;
    }
  }

  return answer;
}
