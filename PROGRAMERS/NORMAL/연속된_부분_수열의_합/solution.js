function solution(sequence, k) {
  let left = 0;
  let right = 0;
  let num = sequence[0];
  let answerLeft = 0;
  let answerRight = 0;
  let answerSize = Infinity;

  while (right < sequence.length) {
    if (num < k) {
      ++right;
      num += sequence[right];
    } else if (num > k) {
      num -= sequence[left];
      ++left;
    } else if (num === k) {
      if (right - left < answerSize) {
        answerLeft = left;
        answerRight = right;
        answerSize = answerRight - answerLeft;
      }
      num -= sequence[left];
      ++left;
      ++right;
      num += sequence[right];
    }
  }

  return [answerLeft, answerRight];
}
