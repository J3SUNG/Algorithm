function solution(players, m, k) {
  let answer = 0;
  let stopServer = new Array(players.length + k).fill(0);
  let curServer = 1;

  players.forEach((item, index) => {
    curServer -= stopServer[index];

    if (curServer * m <= item) {
      const newServer = Math.floor((item + m - curServer * m) / m);

      curServer += newServer;
      stopServer[index + k] += newServer;
      answer += newServer;
    }
  });

  return answer;
}
