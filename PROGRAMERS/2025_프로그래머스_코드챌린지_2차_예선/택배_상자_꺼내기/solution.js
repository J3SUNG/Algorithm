function solution(n, w, num) {
  const map = [];
  let answer = 0;
  let cnt = 1;
  let x, y;

  for (let i = 0; i < Math.ceil(n / w); ++i) {
    const row = [];
    for (let j = 0; j < w; ++j) {
      if (cnt > n) {
        row.push(null);
        continue;
      }

      if (cnt === num) {
        y = i;
        x = Math.ceil(cnt / w) % 2 === 0 ? w - j - 1 : j;
      }

      row.push(cnt);
      ++cnt;
    }

    if (i % 2 === 1) row.reverse();
    map.push(row);
  }

  while (y < map.length && map[y][x] !== null) {
    ++answer;
    ++y;
  }

  return answer;
}
