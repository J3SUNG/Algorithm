function solution(numbers) {
  const size = numbers.length;
  const set = new Set();

  for (let i = 0; i < size; ++i) {
    for (let j = i + 1; j < size; ++j) {
      set.add(numbers[i] + numbers[j]);
    }
  }

  return Array.from(set).sort((a, b) => a - b);
}
