function solution(n, tops) {
  let answer = 0;
  let pair = [1, 2];

  if (tops[0] === 1) {
    pair[1] = 3;
  }

  let temp1, temp2;
  for (let i = 1; i < tops.length; ++i) {
    temp1 = pair[0] * 1;
    temp1 += pair[1] * 1;
    if (tops[i] === 0) {
      temp2 = pair[1] * 2;
      temp2 += pair[0] * 1;
    } else {
      temp2 = pair[1] * 3;
      temp2 += pair[0] * 2;
    }

    pair[0] = temp1 % 10007;
    pair[1] = temp2 % 10007;
  }

  return (pair[0] + pair[1]) % 10007;
}
