function solution(absolutes, signs) {
  let answer = 0;

  absolutes.forEach((item, index) => {
    answer += signs[index] ? item : -item;
  });

  return answer;
}
