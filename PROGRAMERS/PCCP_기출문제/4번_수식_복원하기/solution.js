function solution(expressions) {
  let answer = [];
  let bit = 0b10000000011;
  const fullBit = 0b1111111111;
  let list = [];

  for (const expression of expressions) {
    const [a, op, b, _, value] = expression.split(" ");

    if (value === "X") {
      list.push([a, op, b]);
    }

    let [num1, num2, num3] = [a, b, value === "X" ? 0 : value].map(Number);

    [num1, num2, num3].forEach((num) => {
      num
        .toString()
        .split("")
        .forEach((digit) => {
          bit |= fullBit >> (9 - Number(digit));
        });
    });

    if (value === "X") continue;

    for (let i = 2; i <= 9; ++i) {
      if (bit & (1 << i)) continue;

      let calcValue =
        op === "+" ? parseInt(a, i) + parseInt(b, i) : parseInt(a, i) - parseInt(b, i);

      if (value !== calcValue.toString(i)) {
        bit |= 1 << i;
      }
    }
  }

  for ([a, op, b] of list) {
    let prevValue = null;
    let isInconsistent = false;
    for (let i = 2; i <= 9; ++i) {
      if (bit & (1 << i)) {
        continue;
      }

      let nextValue =
        op === "+"
          ? (parseInt(a, i) + parseInt(b, i)).toString(i)
          : (parseInt(a, i) - parseInt(b, i)).toString(i);

      if (prevValue !== null && prevValue !== nextValue) {
        isInconsistent = true;
        break;
      }

      prevValue = nextValue;
    }

    answer.push(`${a} ${op} ${b} = ${isInconsistent ? "?" : prevValue}`);
  }

  return answer;
}
