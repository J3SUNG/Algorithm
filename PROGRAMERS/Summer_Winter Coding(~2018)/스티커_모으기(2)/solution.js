function solution(sticker) {
  const n = sticker.length;
  if (n === 1) return sticker[0];

  let pick1 = sticker[0],
    skip1 = 0;
  let pick2 = sticker[1],
    skip2 = 0;

  for (let i = 1; i < n - 1; i++) {
    const tempPick1 = skip1 + sticker[i];
    const tempSkip1 = Math.max(pick1, skip1);
    pick1 = tempPick1;
    skip1 = tempSkip1;

    const tempPick2 = skip2 + sticker[i + 1];
    const tempSkip2 = Math.max(pick2, skip2);
    pick2 = tempPick2;
    skip2 = tempSkip2;
  }

  return Math.max(pick1, skip1, pick2, skip2);
}
