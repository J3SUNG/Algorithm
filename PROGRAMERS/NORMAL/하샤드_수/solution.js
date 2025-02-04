function solution(x) {
  return (
    x %
      x
        .toString()
        .split("")
        .map(Number)
        .reduce((a, c) => a + c) ===
    0
  );
}
