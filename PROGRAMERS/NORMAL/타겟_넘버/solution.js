function solution(numbers, target) {
  const memo = new Map();

  function dfs(i, num) {
    const key = `${i},${num}`;
    if (memo.has(key)) return memo.get(key);
    if (i === numbers.length) return num === target ? 1 : 0;

    const plus = dfs(i + 1, num + numbers[i]);
    const minus = dfs(i + 1, num - numbers[i]);
    const result = plus + minus;

    memo.set(key, result);
    return result;
  }

  return dfs(0, 0);
}
