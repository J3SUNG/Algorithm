function solution(scores) {
  let answer = [];
  let totalScore = [];
  let difScore = [];
  let difficult = 0;
  let totalTest1 = 0;
  let totalTest2 = 0;

  for (let i = 0; i < scores.length; ++i) {
    totalTest1 += scores[i][0];
    totalTest2 += scores[i][1];
  }

  if (totalTest1 < totalTest2) {
    difficult = 1;
  } else if (totalTest1 > totalTest2) {
    difficult = 2;
  }

  for (let i = 0; i < scores.length; ++i) {
    if (difficult === 1) {
      difScore = scores[i][0];
    } else if (difficult === 2) {
      difScore = scores[i][1];
    } else {
      difScore = Math.max(scores[i][0], scores[i][1]);
    }
    totalScore.push([scores[i][0] + scores[i][1], difScore, i]);
  }

  totalScore.sort(function (a, b) {
    if (a[0] === b[0]) {
      if (a[1] === b[1]) {
        return a[2] - b[2];
      }
      return b[1] - a[1];
    }
    return b[0] - a[0];
  });

  for (let i = 0; i < totalScore.length; ++i) {
    totalScore[i].push(i + 1);
  }

  totalScore.sort(function (a, b) {
    return a[2] - b[2];
  });

  for (let i = 0; i < totalScore.length; ++i) {
    answer.push(totalScore[i][3]);
  }

  return answer;
}
