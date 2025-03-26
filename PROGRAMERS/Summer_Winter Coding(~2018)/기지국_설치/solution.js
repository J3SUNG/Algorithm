function solution(n, stations, w) {
  let answer = 0;
  let coverage = 2 * w + 1;
  let position = 1;

  for (const station of stations) {
    const start = station - w;

    if (position < start) {
      const gap = start - position;
      answer += Math.ceil(gap / coverage);
    }

    position = station + w + 1;
  }

  if (position <= n) {
    const gap = n - position + 1;
    answer += Math.ceil(gap / coverage);
  }

  return answer;
}
