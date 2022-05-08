function solution(salaries, days) {
  let answer = 0;
  for (let i = 0; i < salaries.length; ++i) {
    if (salaries[i][0] > days) {
      answer += salaries[i];
    } else if (days % salaries[i][0] === 0) {
      answer += salaries[i][1] * parseInt(days / salaries[i][0]);
    } else {
      answer += salaries[i][1] * parseInt(days / salaries[i][0]);
      answer += salaries[i];
    }
  }
  return answer;
}
