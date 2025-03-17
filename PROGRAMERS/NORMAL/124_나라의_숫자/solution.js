function solution(n) {
  let answer = "";

  while (n > 0) {
    let remainder = n % 3;
    if (remainder === 0) {
      remainder = 4;
      n = Math.floor(n / 3) - 1;
    } else {
      n = Math.floor(n / 3);
    }
    answer = remainder + answer;
  }

  return answer;
}
