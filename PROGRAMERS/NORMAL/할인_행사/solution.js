function solution(want, number, discount) {
  const map = {};
  const n = want.length;
  let answer = 0;
  let bit = 0;

  for (let i = 0; i < n; ++i) {
    map[want[i]] = { cnt: 0, index: i };
  }

  const updateBit = (item, delta) => {
    if (map[item]) {
      const { cnt, index } = map[item];
      map[item].cnt += delta;

      if (map[item].cnt >= number[index]) bit |= 1 << index;
      else bit &= ~(1 << index);
    }
  };

  for (let i = 0; i < 10; ++i) {
    updateBit(discount[i], 1);
  }

  if (bit === (1 << n) - 1) ++answer;

  let left = 0;
  let right = 10;
  while (right < discount.length) {
    updateBit(discount[left], -1);
    updateBit(discount[right], 1);

    if (bit === (1 << n) - 1) ++answer;

    ++left;
    ++right;
  }

  return answer;
}
