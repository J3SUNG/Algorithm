function solution(diffs, times, limit) {
  let answer = Infinity;

  let left = 1;
  let right = Math.pow(10, 15);

  while (left <= right) {
    const mid = Math.floor((right + left) / 2);
    let usageTime = 0;
    let timePrev = 0;

    for (let i = 0; i < diffs.length; i++) {
      const failCount = Math.max(diffs[i] - mid, 0);
      usageTime += failCount * (times[i] + timePrev) + times[i];

      if (usageTime > limit) {
        break;
      }

      timePrev = times[i];
    }

    if (usageTime <= limit) {
      answer = Math.min(answer, mid);
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return answer;
}
