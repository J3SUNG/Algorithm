function solution(m, n, puddles) {
  const MOD = 1_000_000_007;
  const dp = Array.from({ length: n }, () => Array(m).fill(0));

  for (const [x, y] of puddles) {
    dp[y - 1][x - 1] = -1;
  }

  dp[0][0] = 1;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (dp[i][j] === -1) continue;

      if (j + 1 < m && dp[i][j + 1] !== -1) {
        dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
      }

      if (i + 1 < n && dp[i + 1][j] !== -1) {
        dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
      }
    }
  }

  return dp[n - 1][m - 1] === -1 ? 0 : dp[n - 1][m - 1];
}
