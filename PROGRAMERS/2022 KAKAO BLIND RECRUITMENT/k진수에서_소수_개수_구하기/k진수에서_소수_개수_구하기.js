function solution(n, k) {
  let answer = 0;
  let s = "";
  let arr;
  n = n.toString(k);
  arr = n.split("0");
  for (let i = 0; i < arr.length; ++i) {
    let chk = false;
    if (arr[i] === "") {
      continue;
    }
    let temp = parseInt(arr[i]);
    if (temp === 1) {
      continue;
    }
    if (temp % 2 === 0) {
      if (temp != 2) {
        chk = true;
      }
    } else {
      for (let i = 3; i <= Math.sqrt(temp); i += 2) {
        if (temp % i === 0) {
          chk = true;
        }
      }
    }
    if (!chk) {
      ++answer;
    }
  }

  return answer;
}
