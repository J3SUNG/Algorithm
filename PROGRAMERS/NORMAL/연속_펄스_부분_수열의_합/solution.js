function solution(sequence) {
  let num1 = sequence[0];
  let num2 = -sequence[0];
  let answer = Math.max(num1, num2);

  for (let i = 1; i < sequence.length; ++i) {
    const curNum1 = i % 2 === 0 ? sequence[i] : -sequence[i];
    const curNum2 = i % 2 === 1 ? sequence[i] : -sequence[i];

    num1 = Math.max(curNum1, num1 + curNum1);
    num2 = Math.max(curNum2, num2 + curNum2);

    answer = Math.max(num1, num2, answer);
  }

  return answer;
}
