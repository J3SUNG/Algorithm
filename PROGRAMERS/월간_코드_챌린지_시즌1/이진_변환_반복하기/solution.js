function solution(s) {
  let str = s;
  let cycleCnt = 0;
  let zeroCnt = 0;

  while (str > 1) {
    let temp = "";

    for (let i = 0; i < str.length; ++i) {
      if (str[i] === "1") {
        temp += "1";
      } else {
        ++zeroCnt;
      }
    }

    str = temp.length.toString(2);
    ++cycleCnt;
  }

  return [cycleCnt, zeroCnt];
}
