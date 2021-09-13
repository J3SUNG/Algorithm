function solution(s) {
  var num = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];
  var size = [4, 3, 3, 5, 4, 4, 3, 5, 5, 4];
  var answer = "";
  var check;
  for (var i = 0; i < s.length; ++i) {
    check = false;
    for (var j = 0; j < 10; ++j) {
      if (i + size[j] > s.length) {
        continue;
      }
      if (s.substring(i, i + size[j]) === num[j]) {
        i += size[j];
        --i;
        answer += String(j);
        check = true;
        break;
      }
    }
    if (!check) {
      answer += s[i];
    }
  }
  return Number(answer);
}
