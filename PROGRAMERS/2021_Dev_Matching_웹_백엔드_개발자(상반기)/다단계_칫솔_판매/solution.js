function solution(enroll, referral, seller, amount) {
  let answer = [];
  const map = new Map();
  const parent = new Map();

  enroll.forEach((item, index) => {
    map.set(item, 0);
    parent.set(item, referral[index]);
  });

  seller.forEach((people, index) => {
    let money = amount[index] * 100;

    calc(people, money, map, parent);
  });

  enroll.forEach((item, index) => {
    answer[index] = map.get(item);
  });

  return answer;
}

function calc(people, money, map, parent) {
  let sendMoney = Math.floor(money / 10, 0);
  money -= sendMoney;

  let currentMoney = map.get(people);
  map.set(people, currentMoney + money);

  let peopleParent = parent.get(people);

  if (sendMoney > 0 && peopleParent !== "-") {
    calc(peopleParent, sendMoney, map, parent);
  }
}
