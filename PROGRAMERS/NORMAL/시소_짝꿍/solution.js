function solution(weights) {
  let answer = 0;
  let list = new Array(1001).fill(0);

  weights.forEach((weight) => list[weight]++);

  for (let i = 100; i <= 1000; ++i) {
    if (list[i] === 0) continue;

    answer += Math.floor((list[i] * (list[i] - 1)) / 2);
    if (i * 2 <= 1000) answer += list[i * 2] * list[i];
    if (i % 3 === 0 && (i / 3) * 2 <= 1000) answer += list[(i / 3) * 2] * list[i];
    if (i % 4 === 0 && (i / 4) * 3) answer += list[(i / 4) * 3] * list[i];
  }

  return answer;
}
