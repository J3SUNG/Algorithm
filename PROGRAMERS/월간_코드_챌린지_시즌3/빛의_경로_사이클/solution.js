function getNextPos(y, x, d, grid) {
  const moveY = [-1, 0, 1, 0];
  const moveX = [0, 1, 0, -1];
  const rows = grid.length;
  const cols = grid[0].length;

  const curY = (y + moveY[d] + rows) % rows;
  const curX = (x + moveX[d] + cols) % cols;
  let curD = d;

  if (grid[curY][curX] === "L") {
    curD = (d + 3) % 4;
  } else if (grid[curY][curX] === "R") {
    curD = (d + 1) % 4;
  }

  return { curY, curX, curD };
}

function solution(grid) {
  const rows = grid.length;
  const cols = grid[0].length;
  const dp = Array.from({ length: rows }, () =>
    Array.from({ length: cols }, () => Array(4).fill(false))
  );
  const answer = [];

  for (let i = 0; i < rows; ++i) {
    for (let j = 0; j < cols; ++j) {
      for (let k = 0; k < 4; ++k) {
        if (!dp[i][j][k]) {
          dp[i][j][k] = 0;
          let y = i;
          let x = j;
          let d = k;
          let cnt = 0;

          while (!dp[y][x][d]) {
            dp[y][x][d] = true;
            cnt++;

            const { curY, curX, curD } = getNextPos(y, x, d, grid);
            y = curY;
            x = curX;
            d = curD;
          }

          answer.push(cnt);
        }
      }
    }
  }

  return answer.sort((a, b) => a - b);
}
