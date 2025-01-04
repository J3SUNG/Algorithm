function solution(n) {
  let a = 1;
  let b = 1;
  let next = 0;

  for (let i = 2; i < n; ++i) {
    next = (a + b) % 1234567;
    a = b;
    b = next;
  }

  return b;
}
