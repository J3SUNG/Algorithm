function solution(N, number) {
  let answer = 987654321;
  let arr = new Array(9).fill().map(() => []);

  arr[1][0] = N * 1;
  arr[2][0] = N * 11;
  arr[3][0] = N * 111;
  arr[4][0] = N * 1111;
  arr[5][0] = N * 11111;

  if (number === arr[1][0]) {
    return 1;
  } else if (number === arr[2][0]) {
    return 2;
  } else if (number === arr[3][0]) {
    return 3;
  } else if (number === arr[4][0]) {
    return 4;
  } else if (number === arr[5][0]) {
    return 5;
  }

  for (let i = 2; i <= 8; ++i) {
    let left = 1;
    let right = i - left;
    while (left <= right) {
      for (j = 0; j < arr[left].length; ++j) {
        for (k = 0; k < arr[right].length; ++k) {
          const add = arr[right][k] + arr[left][j];
          const sub = arr[right][k] - arr[left][j];
          const mul = arr[right][k] * arr[left][j];
          const div = parseInt(arr[right][k] / arr[left][j]);
          const sub2 = arr[left][j] - arr[right][k];
          const div2 = parseInt(arr[left][j] / arr[right][k]);

          insert(left + right, add, arr);
          insert(left + right, sub, arr);
          insert(left + right, mul, arr);
          insert(left + right, div, arr);
          insert(left + right, sub2, arr);
          insert(left + right, div2, arr);

          if (
            add === number ||
            sub === number ||
            mul === number ||
            div === number ||
            sub2 === number ||
            div2 === number
          ) {
            answer = Math.min(answer, left + right);
          }
        }
      }
      ++left;
      --right;
    }
  }

  if (answer > 8) {
    return -1;
  } else {
    return answer;
  }
}

function insert(index, number, arr, record) {
  if (number <= 0) {
    return;
  }

  arr[index].push(number);
}
