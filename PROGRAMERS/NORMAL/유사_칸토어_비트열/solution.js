function getOne(l, r, n, offset = 0) {
  if (n == 0) return 1;

  let size = 5 ** (n - 1);
  let count = 0;
  for (let i = 0; i < 5; i++) {
    let start = offset + i * size;
    let end = start + size - 1;

    if (end < l || start > r) continue;
    if (i === 2) continue;

    if (l <= start && end <= r) {
      count += 4 ** (n - 1);
    } else {
      count += getOne(l, r, n - 1, start);
    }
  }

  return count;
}

function solution(n, l, r) {
  return getOne(l - 1, r - 1, n);
}
