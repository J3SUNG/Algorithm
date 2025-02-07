function solution(s) {
  let answer = [];

  for (const str of s) {
    const stack = [];
    let count110 = 0;

    for (const ch of str) {
      stack.push(ch);
      if (
        stack.length >= 3 &&
        stack[stack.length - 3] === "1" &&
        stack[stack.length - 2] === "1" &&
        stack[stack.length - 1] === "0"
      ) {
        stack.pop();
        stack.pop();
        stack.pop();
        count110++;
      }
    }

    const remaining = stack.join("");
    const lastZeroIndex = remaining.lastIndexOf("0");
    const insertion = "110".repeat(count110);

    let newStr;
    if (lastZeroIndex === -1) {
      newStr = insertion + remaining;
    } else {
      newStr =
        remaining.slice(0, lastZeroIndex + 1) + insertion + remaining.slice(lastZeroIndex + 1);
    }

    answer.push(newStr);
  }

  return answer;
}
