function solution(k, tangerine) {
  let answer = 0;
  let obj = {};

  tangerine.forEach((i) => {
    obj[i] = ++obj[i] || 1;
  });

  const sortObj = Object.values(obj).sort((x, y) => y - x);

  let sum = 0;

  for (let num of sortObj) {
    ++answer;
    sum += num;
    if (k <= sum) {
      break;
    }
  }

  return answer;
}
