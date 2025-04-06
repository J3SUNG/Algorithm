function solution(citations) {
  let answer = 0;
  const n = citations.length;

  citations.sort((a, b) => a - b);

  for (let i = 0; i < n; ++i) {
    if (citations[i] >= n - i) {
      answer = n - i;
      break;
    }
  }

  return answer;
}
