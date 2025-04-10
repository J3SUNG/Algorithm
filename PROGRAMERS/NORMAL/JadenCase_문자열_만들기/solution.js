function solution(s) {
  let answer = "";
  let isNewWord = true;

  for (const c of s) {
    if (c === " ") {
      answer += c;
      isNewWord = true;
    } else {
      if (isNewWord) {
        answer += c.toUpperCase();
        isNewWord = false;
      } else {
        answer += c.toLowerCase();
      }
    }
  }

  return answer;
}
