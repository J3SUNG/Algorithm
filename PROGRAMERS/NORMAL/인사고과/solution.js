function solution(scores) {
  const userScore = scores[0];
  const userSum = userScore[0] + userScore[1];
  let maxPeer = 0;
  let answer = 1;

  scores.sort((a, b) => b[0] - a[0] || a[1] - b[1]);

  const validScores = [];
  for (const [attitude, peer] of scores) {
    if (peer < maxPeer) {
      if (attitude === userScore[0] && peer === userScore[1]) {
        return -1;
      }
    } else {
      maxPeer = Math.max(maxPeer, peer);
      validScores.push(attitude + peer);
    }
  }

  validScores.sort((a, b) => b - a);

  for (const sum of validScores) {
    if (sum === userSum) break;
    ++answer;
  }

  return answer;
}
