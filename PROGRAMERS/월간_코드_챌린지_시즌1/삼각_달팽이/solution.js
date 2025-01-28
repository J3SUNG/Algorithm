function makeMap(num, y, x, d, c, map) {
  // d : 0 아래, 1 오른쪽, 2 위
  let moveY = [1, 0, -1];
  let moveX = [0, 1, 0];
  let nextY = y;
  let nextX = x;

  for (let i = 0; i < c; ++i) {
    nextY += moveY[d];
    nextX += moveX[d];

    map[nextY][nextX] = num + i;
  }

  d = (d + 1) % 3;
  num += c;
  --c;

  if (c === 0) {
    return;
  }

  if (d === 0) {
    makeMap(num, nextY, nextY, d, c, map);
  } else {
    makeMap(num, nextY, nextX, d, c, map);
  }
}

function solution(n) {
  let answer = [];
  let map = Array.from({ length: n }, () => Array.from({ length: n }, () => null));

  makeMap(1, -1, 0, 0, n, map);

  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < n; ++j) {
      if (map[i][j] === null) continue;

      answer.push(map[i][j]);
    }
  }

  return answer;
}
