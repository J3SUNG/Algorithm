function solution(lottos, win_nums) {
  let answer = [];
  let rank = [6, 6, 5, 4, 3, 2, 1];
  let rightNum = 0;
  let zeroNum = 0;

  lottos.forEach((lottoItem) => {
    if (lottoItem === 0) {
      ++zeroNum;
      return;
    }

    win_nums.forEach((winItem) => {
      if (winItem === lottoItem) {
        ++rightNum;
        return;
      }
    });
  });

  answer[0] = rank[rightNum + zeroNum];
  answer[1] = rank[rightNum];

  return answer;
}
