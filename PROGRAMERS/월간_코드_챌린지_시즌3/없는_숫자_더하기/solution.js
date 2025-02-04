function solution(numbers) {
  const num = 45;

  return num - numbers.reduce((a, c) => a + c);
}
