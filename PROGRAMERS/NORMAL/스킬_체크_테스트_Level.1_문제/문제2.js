function solution(arr) {
  var answer = [];
  var minValue = 987654321;
  var index = -1;
  for (var i = 0; i < arr.length; ++i) {
    if (arr[i] < minValue) {
      minValue = arr[i];
      index = i;
    }
  }
  arr.splice(index, 1);
  if (arr.length > 0) {
    answer = arr;
  } else {
    answer[0] = -1;
  }

  return answer;
}
