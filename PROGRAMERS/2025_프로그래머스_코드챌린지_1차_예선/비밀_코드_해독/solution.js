function generateCombinations(n) {
  const results = [];

  function addCombination(num, cnt, arr) {
    if (cnt === 5) {
      results.push([...arr]);
      return;
    }

    for (let i = num + 1; i <= n; ++i) {
      arr.push(i);
      addCombination(i, cnt + 1, arr);
      arr.pop();
    }
  }

  addCombination(0, 0, []);
  return results;
}

function solution(n, q, ans) {
  let combi = generateCombinations(n);

  for (let i = 0; i < q.length; ++i) {
    const querySet = new Set(q[i]);

    combi = combi.filter((arr) => {
      let match = 0;
      for (let num of arr) {
        if (querySet.has(num)) match++;
      }
      return ans[i] === match;
    });
  }

  return combi.length;
}
