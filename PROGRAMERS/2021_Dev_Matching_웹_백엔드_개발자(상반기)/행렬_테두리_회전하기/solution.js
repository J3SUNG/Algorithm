function solution(rows, columns, queries) {
  let answer = [];
  let map = [];

  for (let i = 0; i < rows; ++i) {
    let temp = [];
    for (let j = 0; j < columns; ++j) {
      temp[j] = i * columns + (j + 1);
    }
    map[i] = temp;
  }

  queries.forEach((item, index) => {
    const minNum = solve(map, item);
    answer[index] = minNum;
  });

  return answer;
}

function solve(map, arr) {
  const h = arr[2] - arr[0] + 1;
  const w = arr[3] - arr[1] + 1;
  let y = arr[0] - 1;
  let x = arr[1] - 1;
  let temp = map[y][x];
  let minNum = temp;

  for (let i = 1; i < h; ++i) {
    map[y][x] = map[y + 1][x];
    minNum = Math.min(minNum, map[y][x]);
    ++y;
  }

  for (let i = 1; i < w; ++i) {
    map[y][x] = map[y][x + 1];
    minNum = Math.min(minNum, map[y][x]);
    ++x;
  }

  for (let i = 1; i < h; ++i) {
    map[y][x] = map[y - 1][x];
    minNum = Math.min(minNum, map[y][x]);
    --y;
  }

  for (let i = 1; i < w; ++i) {
    map[y][x] = map[y][x - 1];
    minNum = Math.min(minNum, map[y][x]);
    --x;
  }

  map[y][x + 1] = temp;

  return minNum;
}
