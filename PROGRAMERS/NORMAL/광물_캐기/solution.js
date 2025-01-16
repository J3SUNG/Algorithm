function solution(picks, minerals) {
  let answer = 0;
  const efficiency = [
    [1, 1, 1],
    [1, 1, 5],
    [1, 5, 25],
  ];
  const totalTools = picks.reduce((sum, count) => sum + count, 0);

  let groups = [];
  let groupValue = 0;
  let count = 0;

  for (let i = 0; i < minerals.length && groups.length < totalTools; i++) {
    groupValue += minerals[i] === "diamond" ? 100 : minerals[i] === "iron" ? 10 : 1;
    count++;

    if (count === 5) {
      groups.push(groupValue);
      groupValue = 0;
      count = 0;
    }
  }

  if (groupValue > 0 && groups.length < totalTools) {
    groups.push(groupValue);
  }

  groups.sort((a, b) => b - a);

  for (const value of groups) {
    const toolIndex = picks.findIndex((tool) => tool > 0);
    if (toolIndex === -1) break;

    picks[toolIndex]--;
    answer += Math.floor(value / 100) * efficiency[toolIndex][2];
    answer += Math.floor((value % 100) / 10) * efficiency[toolIndex][1];
    answer += (value % 10) * efficiency[toolIndex][0];
  }

  return answer;
}
