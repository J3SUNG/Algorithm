function solution(number) {
  let answer = 0;
  const size = number.length;

  for (let i = 0; i < size; ++i) {
    for (let j = i + 1; j < size; ++j) {
      for (let k = j + 1; k < size; ++k) {
        if (number[i] + number[j] + number[k] === 0) ++answer;
      }
    }
  }

  return answer;
}
