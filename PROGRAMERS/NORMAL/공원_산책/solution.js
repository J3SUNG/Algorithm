function solution(park, routes) {
  let x, y;
  const ySize = park.length;
  const xSize = park[0].length;

  for (let i = 0; i < ySize; ++i) {
    for (let j = 0; j < xSize; ++j) {
      if (park[i][j] === "S") {
        y = i;
        x = j;
        break;
      }
    }
  }

  const direction = {
    E: [0, 1],
    W: [0, -1],
    S: [1, 0],
    N: [-1, 0],
  };

  routes.forEach((item) => {
    const [command, distStr] = item.split(" ");
    const dist = Number(distStr);
    const [dy, dx] = direction[command];
    let newX = x;
    let newY = y;
    let flag = true;

    for (let i = 0; i < dist; ++i) {
      newY += dy;
      newX += dx;

      if (newX < 0 || newX >= xSize || newY < 0 || newY >= ySize || park[newY][newX] === "X") {
        flag = false;
        break;
      }
    }

    if (flag) {
      x = newX;
      y = newY;
    }
  });

  return [y, x];
}
