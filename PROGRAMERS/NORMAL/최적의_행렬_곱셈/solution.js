function solution(matrix_sizes) {
  const n = matrix_sizes.length;
  const dp = Array.from({ length: n }, () => new Array(n).fill(Infinity));
  const matrices = [matrix_sizes[0][0]];

  for (let i = 0; i < n; ++i) {
    matrices.push(matrix_sizes[i][1]);
    dp[i][i] = 0;
  }

  for (let len = 2; len <= n; len++) {
    for (let i = 0; i <= n - len; i++) {
      const j = i + len - 1;

      for (let k = i; k < j; k++) {
        const cost = dp[i][k] + dp[k + 1][j] + matrices[i] * matrices[k + 1] * matrices[j + 1];
        dp[i][j] = Math.min(dp[i][j], cost);
      }
    }
  }

  return dp[0][n - 1];
}
