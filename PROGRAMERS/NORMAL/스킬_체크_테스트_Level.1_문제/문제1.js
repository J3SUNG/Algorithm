function solution(arr1, arr2) {
  var answer = [];
  var arr = [];
  for (var i = 0; i < arr1.length; ++i) {
    for (var j = 0; j < arr1[0].length; ++j) {
      arr.push(arr1[i][j] + arr2[i][j]);
    }
    answer.push(arr.slice());
    while (arr.length > 0) {
      arr.pop();
    }
  }
  return answer;
}
