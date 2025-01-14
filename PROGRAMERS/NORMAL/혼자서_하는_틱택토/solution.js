function solution(board) {
  let oCnt = 0;
  let xCnt = 0;
  let oBingo = 0;
  let xBingo = 0;

  const isBingo = (a, b, c) => a !== "." && a === b && a === c;

  for (let i = 0; i < 3; ++i) {
    for (let j = 0; j < 3; ++j) {
      if (board[i][j] === "O") oCnt++;
      else if (board[i][j] === "X") xCnt++;
    }
    if (isBingo(board[i][0], board[i][1], board[i][2])) {
      board[i][0] === "O" ? oBingo++ : xBingo++;
    }
    if (isBingo(board[0][i], board[1][i], board[2][i])) {
      board[0][i] === "O" ? oBingo++ : xBingo++;
    }
  }

  if (isBingo(board[0][0], board[1][1], board[2][2])) {
    board[0][0] === "O" ? oBingo++ : xBingo++;
  }
  if (isBingo(board[0][2], board[1][1], board[2][0])) {
    board[0][2] === "O" ? oBingo++ : xBingo++;
  }

  if (!(oCnt === xCnt || oCnt === xCnt + 1)) return 0;
  if (oBingo > 0 && xBingo > 0) return 0;
  if (oBingo > 0 && oCnt !== xCnt + 1) return 0;
  if (xBingo > 0 && oCnt !== xCnt) return 0;

  return 1;
}
