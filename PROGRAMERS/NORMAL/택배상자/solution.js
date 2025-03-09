function solution(order) {
  const stack = [];
  let answer = 0;
  let orderIndex = 0;
  const n = order.length;

  for (let i = 1; i <= n; i++) {
    if (i === order[orderIndex]) {
      answer++;
      orderIndex++;
      while (stack.length && stack[stack.length - 1] === order[orderIndex]) {
        stack.pop();
        answer++;
        orderIndex++;
      }
    } else {
      stack.push(i);
    }
  }

  return answer;
}
