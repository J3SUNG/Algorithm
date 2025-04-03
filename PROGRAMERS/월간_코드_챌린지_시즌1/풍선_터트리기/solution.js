function solution(a) {
  let answer = 0;
  const n = a.length;
  const MAX_VALUE = 1_000_000_001;

  let leftMin = new Array(n + 2).fill(MAX_VALUE);
  let rightMin = new Array(n + 2).fill(MAX_VALUE);

  for (let i = 1; i <= n; ++i) {
    leftMin[i] = Math.min(leftMin[i - 1], a[i - 1]);
    rightMin[n - i + 1] = Math.min(rightMin[n - i + 2], a[n - i]);
  }

  for (let i = 0; i < n; ++i) {
    if (a[i] < leftMin[i] || a[i] < rightMin[i + 2]) ++answer;
  }

  return answer;
}
