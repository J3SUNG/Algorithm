function solution(word) {
  const chars = ["A", "E", "I", "O", "U"];
  let count = 0;

  function dfs(str) {
    if (str === word) return count;
    if (str.length === 5) return null;

    for (let i = 0; i < 5; i++) {
      count++;
      const result = dfs(str + chars[i]);
      if (result !== null) return result;
    }

    return null;
  }

  return dfs("");
}
