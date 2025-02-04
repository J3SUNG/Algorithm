function solution(arr1, arr2) {
  let answer = new Array(arr1.length);

  for (let i = 0, row = arr1.length, col = arr1[0].length; i < row; ++i) {
    answer[i] = new Array(col);
    for (let j = 0; j < col; ++j) {
      answer[i][j] = arr1[i][j] + arr2[i][j];
    }
  }

  return answer;
}
