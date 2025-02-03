function solution(sales, links) {
  const n = sales.length;
  const children = Array.from({ length: sales.length + 1 }, () => []);

  for (const [p, c] of links) {
    children[p].push(c);
  }

  function dfs(node) {
    let dpOn = sales[node - 1];
    let dpOff = 0;
    let hasOn = false;
    let extra = Infinity;

    for (const child of children[node]) {
      const [childOn, childOff] = dfs(child);

      dpOn += Math.min(childOn, childOff);

      if (childOn <= childOff) {
        dpOff += childOn;
        hasOn = true;
      } else {
        dpOff += childOff;
        extra = Math.min(extra, childOn - childOff);
      }
    }

    if (children[node].length && !hasOn) {
      dpOff += extra;
    }

    return [dpOn, dpOff];
  }

  const [on, off] = dfs(1);
  return Math.min(on, off);
}
