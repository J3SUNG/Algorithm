function solution(points, routes) {
  let answer = 0;
  const map = Array.from({ length: 101 }, () =>
    Array.from({ length: 101 }, () => ({ num: 0, cycle: 0 }))
  );

  let data = routes.map((item, index) => {
    const cy = points[item[0] - 1][0];
    const cx = points[item[0] - 1][1];
    const ey = points[item[1] - 1][0];
    const ex = points[item[1] - 1][1];

    return { cy, cx, ey, ex, index, next: 2 };
  });

  let cycle = 1;
  while (0 < data.length) {
    const dataSize = data.length;
    let conflict = 0;

    for (let i = 0; i < dataSize; ++i) {
      let { cy, cx, ey, ex, index, next } = data[0];
      data.shift();

      if (map[cy][cx].cycle < cycle) {
        map[cy][cx].cycle = cycle;
        map[cy][cx].num = 0;
      }

      ++map[cy][cx].num;

      if (map[cy][cx].num === 2) {
        ++conflict;
      }

      if (cy === ey && cx === ex && next < routes[index].length) {
        ey = points[routes[index][next] - 1][0];
        ex = points[routes[index][next] - 1][1];
        ++next;
      }

      if (cy === ey && cx === ex) {
        continue;
      }

      if (cy === ey) {
        cx += cx > ex ? -1 : 1;
      } else {
        cy += cy > ey ? -1 : 1;
      }

      data.push({ cy, cx, ey, ex, index, next });
    }

    answer += conflict;
    ++cycle;
  }

  return answer;
}
