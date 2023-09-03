function solution(numbers, hand) {
  var answer = "";
  var keypad = [
    ["1", "4", "7", "*"],
    ["2", "5", "8", "0"],
    ["3", "6", "9", "#"],
  ];
  var nowLeft = 3;
  var nowRight = 3;
  var left, right;
  var leftHandCenter = false;
  var rightHandCenter = false;
  var j, k;
  var find;

  for (var i = 0; i < numbers.length; ++i) {
    find = false;
    for (j = 0; j < 3; ++j) {
      for (k = 0; k < 4; ++k) {
        if (numbers[i] === keypad[j][k]) {
          find = true;
          break;
        }
      }
      if (find) {
        break;
      }
    }
    if (j === 0) {
      leftHandCenter = false;
      nowLeft = k;
      answer += "L";
    } else if (j === 2) {
      rightHandCenter = false;
      nowRight = k;
      answer += "R";
    } else {
      left = Math.abs(nowLeft - k);
      right = Math.abs(nowRight - k);
      leftHandCenter ? (left -= 1) : true;
      rightHandCenter ? (right -= 1) : true;
      if (left < right) {
        leftHandCenter = true;
        nowLeft = k;
        answer += "L";
      } else if (left > right) {
        rightHandCenter = true;
        nowRight = k;
        answer += "R";
      } else {
        if (hand === "left") {
          leftHandCenter = true;
          nowLeft = k;
          answer += "L";
        } else {
          rightHandCenter = true;
          nowRight = k;
          answer += "R";
        }
      }
    }
  }
  return answer;
}
