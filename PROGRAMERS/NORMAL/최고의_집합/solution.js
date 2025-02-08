function solution(n, s) {
  if (s < n) return [-1];

  const mid = Math.floor(s / n);
  const sub = s % n;

  return Array(n)
    .fill(mid)
    .map((v, i) => (i < n - sub ? v : v + 1));
}
