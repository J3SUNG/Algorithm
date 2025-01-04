function solution(s) {
  const numbers = s.split(" ");

  const { min, max } = numbers.reduce(
    (a, c) => ({
      min: Math.min(a.min, c),
      max: Math.max(a.max, c),
    }),
    { min: Infinity, max: -Infinity }
  );

  return `${min} ${max}`;
}
