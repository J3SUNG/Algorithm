function solution(n) {
  function dfs(left, right) {
    let count = 0;

    if (left === n && right === n) return 1;
    if (left < n) count += dfs(left + 1, right);
    if (left > right) count += dfs(left, right + 1);

    return count;
  }

  return dfs(0, 0);
}
