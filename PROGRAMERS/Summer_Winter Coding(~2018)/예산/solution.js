function solution(d, budget) {
  d.sort((a, b) => a - b);

  let sum = 0;
  for (let i = 0; i < d.length; ++i) {
    sum += d[i];

    if (sum > budget) {
      return i;
    }
  }

  return d.length;
}
