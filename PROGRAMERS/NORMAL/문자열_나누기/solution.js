function solution(s) {
  let answer = 0;
  let count = 0;
  let base = "";

  for (const char of s) {
    base ||= char;

    count += char === base ? 1 : -1;

    if (count === 0) {
      ++answer;
      base = "";
    }
  }

  if (base) ++answer;

  return answer;
}
