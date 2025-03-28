function solution(n, money) {
  const MOD = 1_000_000_007;
  const dp = new Array(n + 1).fill(0);
  dp[0] = 1;

  for (const m of money) {
    for (let i = m; i <= n; ++i) {
      dp[i] = (dp[i] + dp[i - m]) % MOD;
    }
  }

  return dp[n];
}
