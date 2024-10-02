function solution(coin, cards) {
  let answer = 1;
  let list = [];
  let newList = [];
  let needCard = cards.length + 1;
  let nextCount = 0;
  let needTwoCoin = 0;

  for (let i = 0; i < cards.length / 3; ++i) {
    if (list[cards[i]] === undefined) {
      list[cards[i]] = 0;
      newList[cards[i]] = 0;
    }

    if (list[needCard - cards[i]] > 0) {
      ++nextCount;
      --list[needCard - cards[i]];
    } else {
      ++list[cards[i]];
    }
  }

  for (let i = cards.length / 3; i < cards.length; i += 2) {
    for (let j = 0; j < 2; ++j) {
      if (list[cards[i + j]] === undefined) {
        list[cards[i + j]] = 0;
        newList[cards[i + j]] = 0;
      }

      if (list[needCard - cards[i + j]] > 0 && coin >= 1) {
        ++nextCount;
        --list[needCard - cards[i + j]];
        coin -= 1;
      } else if (newList[needCard - cards[i + j]] > 0) {
        ++needTwoCoin;
        --newList[needCard - cards[i + j]];
      } else {
        ++newList[cards[i + j]];
      }
    }

    ++answer;
    if (nextCount > 0) {
      --nextCount;
    } else if (coin >= 2 && needTwoCoin > 0) {
      --needTwoCoin;
      coin -= 2;
    } else {
      --answer;
      break;
    }
  }

  return answer;
}
