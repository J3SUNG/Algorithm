function solution(maps) {
  const rows = maps.length;
  const cols = maps[0].length;
  const visited = Array.from({ length: rows }, () => Array(cols).fill(false));
  let answer = [];

  function dfs(y, x) {
    const dx = [1, 0, -1, 0];
    const dy = [0, 1, 0, -1];
    let sum = Number(maps[y][x]);
    visited[y][x] = true;

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (
        ny >= 0 &&
        ny < rows &&
        nx >= 0 &&
        nx < cols &&
        !visited[ny][nx] &&
        maps[ny][nx] !== "X"
      ) {
        sum += dfs(ny, nx);
      }
    }
    return sum;
  }

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (maps[i][j] !== "X" && !visited[i][j]) {
        answer.push(dfs(i, j));
      }
    }
  }

  return answer.length ? answer.sort((a, b) => a - b) : [-1];
}
