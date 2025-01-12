function dfs(y, x, group, land) {
  const moveY = [0, 1, 0, -1];
  const moveX = [1, 0, -1, 0];
  let stack = [[y, x]];
  let oilSize = 0;

  while (stack.length > 0) {
    const [curY, curX] = stack.pop();

    if (land[curY][curX] !== 1) {
      continue;
    }

    land[curY][curX] = group;
    ++oilSize;

    for (let i = 0; i < 4; ++i) {
      const nextY = curY + moveY[i];
      const nextX = curX + moveX[i];

      if (isValid(nextY, nextX, land)) {
        stack.push([nextY, nextX]);
      }
    }
  }

  return oilSize;
}

function isValid(y, x, land) {
  return y >= 0 && x >= 0 && y < land.length && x < land[0].length && land[y][x] === 1;
}

function solution(land) {
  let answer = 0;
  let group = 2;
  let groupCnt = [0, 0];

  for (let i = 0; i < land.length; ++i) {
    for (let j = 0; j < land[0].length; ++j) {
      if (land[i][j] === 1) {
        const oilSize = dfs(i, j, group, land);
        groupCnt.push(oilSize);
        ++group;
      }
    }
  }

  for (let i = 0; i < land[0].length; ++i) {
    let visitOilGroup = new Array(group).fill(false);
    let sum = 0;

    for (let j = 0; j < land.length; ++j) {
      const oilNum = land[j][i];
      if (oilNum > 1 && !visitOilGroup[oilNum]) {
        sum += groupCnt[oilNum];
        visitOilGroup[oilNum] = true;
      }
    }

    answer = Math.max(answer, sum);
  }

  return answer;
}
