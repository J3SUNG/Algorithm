function solution(elements) {
  const n = elements.length;
  const set = new Set();

  let arr = Array(n).fill(0);
  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < n; ++j) {
      arr[j] += elements[(j + i) % n];
      set.add(arr[j]);
    }
  }

  return set.size;
}
