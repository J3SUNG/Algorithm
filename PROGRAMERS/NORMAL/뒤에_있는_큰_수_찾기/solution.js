function solution(numbers) {
  const answer = new Array(numbers.length).fill(-1);
  const stack = [];

  numbers.forEach((number, index) => {
    while (stack.length > 0 && stack[stack.length - 1][0] < number) {
      const [, topIndex] = stack.pop();
      answer[topIndex] = number;
    }
    stack.push([number, index]);
  });

  return answer;
}
