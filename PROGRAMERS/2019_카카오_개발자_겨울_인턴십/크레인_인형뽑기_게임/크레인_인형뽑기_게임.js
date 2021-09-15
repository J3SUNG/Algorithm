function solution(board, moves) {
  let answer = 0;
  let stack = [];
  let index = 1;
  let x, y;
  let height = [];

  for (let i = 0; i < board[0].length; ++i) {
    height[i] = 0;
  }
  stack[0] = 0;

  for (let i = 0; i < board.length; ++i) {
    for (let j = 0; j < board[i].length; ++j) {
      if (board[i][j] !== 0) {
        height[j] = Math.max(height[j], board.length - i);
      }
    }
  }

  for (let i = 0; i < moves.length; ++i) {
    x = moves[i] - 1;
    y = board.length - height[x];
    if (board[y][x] === 0) {
      continue;
    }
    if (height[x] > 1) {
      --height[x];
    }

    stack[index] = board[y][x];
    if (stack[index] === stack[index - 1]) {
      answer += 2;
      --index;
      stack = stack.slice(0, index);
    } else {
      ++index;
    }
    board[y][x] = 0;
  }

  return answer;
}
