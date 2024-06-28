function solution(a, b) {
  return a.reduce((acc, cur, index) => acc + cur * b[index], 0);
}
