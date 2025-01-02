function solution(keymap, targets) {
  let alp = new Array(26).fill(Infinity);

  for (const keyArr of keymap) {
    [...keyArr].forEach((key, index) => {
      const pos = key.charCodeAt(0) - 65;
      alp[pos] = Math.min(alp[pos], index + 1);
    });
  }

  return targets.map((keyArr) => {
    let total = 0;

    for (key of keyArr) {
      const pos = key.charCodeAt(0) - 65;
      if (alp[pos] === Infinity) return -1;
      total += alp[pos];
    }

    return total;
  });
}
