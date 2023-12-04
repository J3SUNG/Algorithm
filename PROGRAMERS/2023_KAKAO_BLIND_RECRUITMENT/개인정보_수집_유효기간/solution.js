function solution(today, terms, privacies) {
  let answer = [];
  let calcToday = calc(today);

  privacies.map((privacy, index) => {
    let privacyArr = privacy.split(" ");
    let termValue = terms.filter((term, index) => {
      let termArr = term.split(" ");

      if (privacyArr[1] === termArr[0]) {
        return true;
      }
    });

    if (calcToday >= calc(privacyArr[0], termValue[0].split(" ")[1])) {
      answer.push(index + 1);
    }
  });

  return answer;
}

function calc(day, add = 0) {
  let arr = day.split(".").map(Number);
  let value = arr[0] * 12 * 28 + arr[1] * 28 + arr[2] + add * 28;
  return value;
}
