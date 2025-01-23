function solution(temperature, t1, t2, a, b, onboard) {
  let dp = [];

  for (let i = 0; i <= 1000; ++i) {
    dp.push([]);
    for (let j = 0; j <= 51; ++j) {
      dp[i].push(Infinity);
    }
  }

  t1 += 10;
  t2 += 10;
  temperature += 10;
  dp[0][temperature] = 0;

  for (let i = 0; i < onboard.length; ++i) {
    for (let j = 0; j <= 50; ++j) {
      if (dp[i][j] === Infinity) {
        continue;
      }

      if (!onboard[i] || (j + 1 >= t1 && j + 1 <= t2)) {
        if (j < temperature) {
          dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
        }
        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + a);
      }
      if (!onboard[i] || (j - 1 >= t1 && j - 1 <= t2)) {
        if (j > temperature) {
          dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j]);
        }
        dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + a);
      }
      if (!onboard[i] || (j >= t1 && j <= t2)) {
        if (j === temperature) {
          dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
        }
        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);
      }
    }
  }

  return Math.min(...dp[onboard.length]);
}
