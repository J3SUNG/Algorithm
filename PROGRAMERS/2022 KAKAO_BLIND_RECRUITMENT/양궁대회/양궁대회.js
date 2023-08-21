function solution(n, info) {
  let ans = [-1];
  let answer = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  let aScore = 0;
  let bScore = 0;
  let max = 0;
  for (let i = 0; i < 10; ++i) {
    bScore += info[i] > 0 ? 10 - i : 0;
  }
  for (let i = 0; i <= 10; ++i) {
    if (info[i] < n) {
      DFS(
        i,
        n - info[i] - 1,
        info[i],
        10 - i,
        info[i] > 0 ? bScore - (10 - i) : bScore
      );
    }
  }
  function DFS(index, value, sub, aScore, bScore) {
    answer[index] = sub + 1;
    for (let i = index + 1; i <= 10; ++i) {
      if (info[i] < value) {
        DFS(
          i,
          value - info[i] - 1,
          info[i],
          aScore + (10 - i),
          info[i] > 0 ? bScore - (10 - i) : bScore
        );
      }
      if (index === 10) {
        answer[10] += value;
        value = 0;
      }
    }
    answer[10] = value;
    let chk = false;
    if (max === aScore - bScore) {
      for (let i = 0; i <= 10; ++i) {
        if (ans[10 - i] < answer[10 - i]) {
          chk = true;
          break;
        } else if (ans[10 - i] > answer[10 - i]) {
          break;
        }
      }
    }
    if (max < aScore - bScore || chk) {
      max = aScore - bScore;
      for (let i = 0; i <= 10; ++i) {
        ans[i] = answer[i];
      }
    }
    max = Math.max(max, aScore - bScore);
    if (max === 0) {
      ans = [-1];
    }
    answer[index] = 0;
  }
  return ans;
}
