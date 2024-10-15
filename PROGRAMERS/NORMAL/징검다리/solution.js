function solution(distance, rocks, n) {
  let answer = 0;
  let cur = 0;

  rocks.sort((a, b) => parseInt(a) - parseInt(b));
  let dist = rocks.map((item) => {
    let value = item - cur;
    cur = item;
    return value;
  });
  dist.push(distance - cur);

  let left = 0;
  let right = distance;
  let mid = 0;
  while (left <= right) {
    let count = 0;
    mid = parseInt((left + right) / 2);

    let sum = 0;
    for (let i = 0; i < dist.length; ++i) {
      sum += dist[i];
      if (sum >= mid) {
        sum = 0;
      } else {
        ++count;
      }
    }

    if (count <= n) {
      left = mid + 1;
      answer = mid;
    } else {
      right = mid - 1;
    }
  }

  return answer;
}
