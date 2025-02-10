function solution(storey) {
  let down = 0;
  let up = 1;

  while (storey > 0) {
    const num1 = 10 - (storey % 10);
    const num2 = storey % 10;

    [up, down] = [Math.min(down + num1, up + num1 - 1), Math.min(down + num2, up + num2 + 1)];
    storey = Math.floor(storey / 10);
  }

  return Math.min(up + 1, down);
}
