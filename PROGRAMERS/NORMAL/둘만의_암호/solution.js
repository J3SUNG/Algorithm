function solution(s, skip, index) {
  let answer = "";
  let skipSet = new Set(skip);

  let validChars = [];
  for (let i = 0; i < 26; i++) {
    let char = String.fromCharCode(i + 97);
    if (!skipSet.has(char)) validChars.push(char);
  }

  for (let c of s) {
    let idx = validChars.indexOf(c);
    let newIdx = (idx + index) % validChars.length;
    answer += validChars[newIdx];
  }

  return answer;
}
