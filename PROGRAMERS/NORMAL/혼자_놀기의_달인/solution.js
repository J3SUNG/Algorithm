function solution(cards) {
  const n = cards.length;
  const visit = new Array(n).fill(false);
  let first = 0,
    second = 0;

  const dfs = (index) => {
    let count = 0;
    while (!visit[index]) {
      visit[index] = true;
      index = cards[index] - 1;
      count++;
    }
    return count;
  };

  for (let i = 0; i < n; i++) {
    if (visit[i]) continue;
    const size = dfs(i);

    if (size > first) {
      second = first;
      first = size;
    } else if (size > second) {
      second = size;
    }
  }

  return first * second;
}
