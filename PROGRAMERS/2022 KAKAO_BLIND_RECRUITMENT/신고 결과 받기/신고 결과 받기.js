function solution(id_list, report, k) {
  let answer = [];
  let arr = [];
  let reportFrom = [];
  let prevFrom = "";
  let prevTo = "";
  for (let i = 0; i < id_list.length; ++i) {
    let temp = [];
    reportFrom.push(temp);
    arr[i] = 0;
    answer[i] = 0;
  }
  report.sort();
  for (let i = 0; i < report.length; ++i) {
    let temp = [];
    let str = report[i].split(" ");
    let f, t;
    if (prevFrom == str[0] && prevTo == str[1]) {
      continue;
    }
    for (let j = 0; j < id_list.length; ++j) {
      if (str[0] == id_list[j]) {
        f = j;
      }
      if (str[1] == id_list[j]) {
        t = j;
      }
    }
    reportFrom[t].push(f);
    temp.push(str[0]);
    prevFrom = str[0];
    prevTo = str[1];
    ++arr[t];
  }
  for (let i = 0; i < arr.length; ++i) {
    if (arr[i] < k) {
      continue;
    }
    for (let j = 0; j < reportFrom.length; ++j) {
      ++answer[reportFrom[i][j]];
    }
  }
  return answer;
}
