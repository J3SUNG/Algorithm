function solution(n, k) {
  const answer = [];
  const arr = Array.from({ length: n }, (_, i) => i + 1);
  const factorials = [1];

  for (let i = 1; i <= n; i++) {
    factorials[i] = factorials[i - 1] * i;
  }

  let num = k - 1;

  for (let i = n; i > 0; i--) {
    const index = Math.floor(num / factorials[i - 1]);
    num %= factorials[i - 1];
    answer.push(arr[index]);
    arr.splice(index, 1);
  }

  return answer;
}
