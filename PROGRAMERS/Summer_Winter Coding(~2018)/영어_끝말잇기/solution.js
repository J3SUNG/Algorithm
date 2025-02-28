function solution(n, words) {
  const set = new Set();
  let lastWord = words[0][0];

  for (let i = 0; i < words.length; ++i) {
    const currentWord = words[i];

    if (currentWord[0] !== lastWord || set.has(currentWord)) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    }

    set.add(words[i]);
    lastWord = currentWord[currentWord.length - 1];
  }

  return [0, 0];
}
