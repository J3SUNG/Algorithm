function solution(board, aloc, bloc) {
  let answer = -1;
  const rowSize = board.length;
  const colSize = board[0].length;
  const d = [
    [0, 1],
    [1, 0],
    [-1, 0],
    [0, -1],
  ];
  let CHK = (y, x) => {
    return y < 0 || x < 0 || y >= rowSize || x >= colSize;
  };
  let DFS = (curLoc, nextLoc) => {
    let ret = 0;
    if (!board[curLoc[0]][curLoc[1]]) {
      return 0;
    }
    board[curLoc[0]][curLoc[1]] = 0;
    for (let i = 0; i < 4; ++i) {
      nextY = curLoc[0] + d[i][0];
      nextX = curLoc[1] + d[i][1];
      if (CHK(nextY, nextX) || !board[nextY][nextX]) {
        continue;
      }
      let count = DFS(nextLoc, [nextY, nextX]) + 1;

      if (ret % 2 === 0 && count % 2 === 1) {
        ret = count;
      } else if (ret % 2 === 0 && count % 2 === 0) {
        ret = Math.max(ret, count);
      } else if (ret % 2 === 1 && count % 2 === 1) {
        ret = Math.min(ret, count);
      }
    }
    board[curLoc[0]][curLoc[1]] = 1;
    return ret;
  };
  answer = DFS(aloc, bloc);

  return answer;
}
