function getTime(time) {
  return parseInt(time.slice(0, 2)) * 60 + parseInt(time.slice(3));
}

function solution(plans) {
  let answer = [];

  plans.sort((a, b) => getTime(a[1]) - getTime(b[1]));

  let testStack = [];
  let prevTime = 0;

  for (const [test, time, duringStr] of plans) {
    const curTime = getTime(time);
    const during = Number(duringStr);
    let remainingTime = curTime - prevTime;

    while (remainingTime > 0 && testStack.length > 0) {
      const [prevTest, prevDuring] = testStack.pop();

      if (prevDuring > remainingTime) {
        testStack.push([prevTest, prevDuring - remainingTime]);
        break;
      }

      answer.push(prevTest);
      remainingTime -= prevDuring;
    }

    testStack.push([test, during]);
    prevTime = curTime;
  }

  while (testStack.length > 0) {
    answer.push(testStack.pop()[0]);
  }

  return answer;
}
