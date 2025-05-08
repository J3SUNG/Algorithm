function solution(sizes) {
  let maxW = 0;
  let maxH = 0;

  for (const [a, b] of sizes) {
    const [w, h] = a < b ? [a, b] : [b, a];
    maxW = Math.max(maxW, w);
    maxH = Math.max(maxH, h);
  }

  return maxW * maxH;
}
