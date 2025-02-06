function isValid(s) {
  const stack = [];
  const pairs = { ")": "(", "]": "[", "}": "{" };

  for (let char of s) {
    if (char === "(" || char === "[" || char === "{") {
      stack.push(char);
    } else if (stack.length > 0 && stack[stack.length - 1] === pairs[char]) {
      stack.pop();
    } else {
      return false;
    }
  }

  return stack.length === 0;
}

function solution(s) {
  let count = 0;
  const size = s.length;

  for (let i = 0; i < size; i++) {
    if (isValid(s)) count++;
    s = s.slice(1) + s[0];
  }

  return count;
}
