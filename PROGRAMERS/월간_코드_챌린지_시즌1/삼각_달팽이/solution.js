function solution(n) {
  let answer = [];
  let map = Array.from({ length: n }, () => []);

  let y = -1;
  let x = 0;
  let num = 1;
  let d = 0;
  let dir = [
    [1, 0],
    [0, 1],
    [-1, -1],
  ];

  for (let i = n; i > 0; --i) {
    for (let j = 0; j < i; ++j) {
      y += dir[d][0];
      x += dir[d][1];
      map[y][x] = num;
      ++num;
    }
    d = (d + 1) % 3;
  }

  for (const row of map) {
    answer.push(...row);
  }

  return answer;
}
