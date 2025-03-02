function solution(data, col, row_begin, row_end) {
  let answer = 0;

  data.sort((a, b) => a[col - 1] - b[col - 1] || b[0] - a[0]);

  for (let i = row_begin - 1; i < row_end; ++i) {
    let num = data[i].reduce((sum, item) => sum + (item % (i + 1)), 0);
    answer ^= num;
  }

  return answer;
}
