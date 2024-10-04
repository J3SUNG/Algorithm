function solution(numbers) {
  let answer = [];

  numbers.forEach((number) => {
    let binary = number.toString(2);
    let numberSize = binary.length;
    let size = getTreeSize(numberSize);
    let newBinary = addZero(binary, size - numberSize);

    answer.push(checkPossible(newBinary, 0, size - 1, true) ? 1 : 0);
  });

  return answer;
}

function getTreeSize(cur, treeSize = 1) {
  if (cur > treeSize) {
    treeSize = getTreeSize(cur, treeSize * 2 + 1);
  }

  return treeSize;
}

function addZero(binary, count) {
  let stringNumber = binary.toString();
  let zero = "";

  for (let i = 0; i < count; ++i) {
    zero += "0";
  }

  return zero + stringNumber;
}

function checkPossible(number, left, right, possible) {
  let center = (left + right) / 2;
  let result = true;

  if (number[center] === "1") {
    if (!possible) {
      return false;
    }
  } else {
    possible = false;
  }

  if (left === right) {
    return true;
  }

  result =
    checkPossible(number, left, center - 1, possible) &&
    checkPossible(number, center + 1, right, possible);

  return result;
}
