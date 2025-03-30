function solution(n, cores) {
  const m = cores.length;
  if (n <= m) return n;

  let left = 0;
  let right = Math.max(...cores) * n;
  let time = 0;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    const done = cores.reduce((sum, t) => sum + Math.floor(mid / t), 0) + m;

    if (done >= n) {
      time = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  const doneBefore = cores.reduce((sum, t) => sum + Math.floor((time - 1) / t), 0) + m;
  let remain = n - doneBefore;

  for (let i = 0; i < m; i++) {
    if (time % cores[i] === 0) {
      remain--;
      if (remain === 0) return i + 1;
    }
  }
}
