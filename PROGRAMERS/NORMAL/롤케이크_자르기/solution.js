function solution(topping) {
  let answer = 0;
  const n = topping.length;
  const leftMap = new Map();
  const rightMap = new Map();
  let leftCnt = 0;
  let rightCnt = 0;

  for (const num of topping) {
    rightMap.set(num, (rightMap.get(num) || 0) + 1);
    if (rightMap.get(num) === 1) ++rightCnt;
  }

  for (const num of topping) {
    if (!leftMap.has(num)) {
      leftMap.set(num, 1);
      ++leftCnt;
    } else {
      leftMap.set(num, leftMap.get(num) + 1);
    }

    const rightCount = rightMap.get(num) - 1;
    if (rightCount === 0) {
      rightMap.delete(num);
      --rightCnt;
    } else {
      rightMap.set(num, rightCount);
    }

    if (leftCnt === rightCnt) ++answer;
  }

  return answer;
}
