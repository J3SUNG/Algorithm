function solution(n, m, section) {
  let answer = 0;
  let pos = -1;

  for (const item of section) {
    if (item >= pos) {
      pos = item + m;
      ++answer;
    }
  }

  return answer;
}
