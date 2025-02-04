function solution(n) {
  let x = n - 1;

  for (let i = 2; i * i <= x; i++) {
    if (x % i === 0) return i;
  }

  return x;
}
