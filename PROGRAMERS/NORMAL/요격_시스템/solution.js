function solution(targets) {
  let answer = 0;

  targets.sort((a, b) => a[1] - b[1]);

  let curNum = -1;
  for (const [a, b] of targets) {
    if (a >= curNum) {
      curNum = b;
      ++answer;
    }
  }

  return answer;
}
