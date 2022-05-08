function dfs(i, j, alp, board) {
  let move = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  let x, y;
  let num = 1;
  board[i] = [board[i].slice(0, j), " ", board[i].slice(j + 1)].join("");
  for (let k = 0; k < 4; ++k) {
    y = i + move[k][0];
    x = j + move[k][1];
    if (y < 0 || x < 0) {
      continue;
    }
    if (y >= board.length || x > board.length) {
      continue;
    }
    if (board[y][x] === alp) {
      num += dfs(y, x, alp, board);
    }
  }

  return num;
}

function solution(board) {
  let board2 = [[]];
  let answer = 0;
  let num;
  let alp;

  for (let i = 0; i < board.length; ++i) {
    num = 0;
    board2 = board.map((v) => v.slice());
    for (let j = 0; j < board.length; ++j) {
      if (board2[i][j] === " ") {
        continue;
      }
      alp = board2[i][j];
      num += dfs(i, j, alp, board2, 0);
    }
    if (answer < num) {
      answer = num;
    }
  }

  for (let i = 0; i < board.length; ++i) {
    num = 0;
    board2 = board;
    for (let j = 0; j < board.length; ++j) {
      if (board2[j][i] === " ") {
        continue;
      }
      alp = board2[j][i];
      num += dfs(j, i, alp, board2, 0);
    }
    if (answer < num) {
      answer = num;
    }
  }
  return answer;
}
