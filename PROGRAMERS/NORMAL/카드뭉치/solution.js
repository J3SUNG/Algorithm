function solution(cards1, cards2, goal) {
  let index1 = 0;
  let index2 = 0;

  for (word of goal) {
    if (index1 < cards1.length && word === cards1[index1]) {
      index1++;
    } else if (index2 < cards2.length && word === cards2[index2]) {
      index2++;
    } else {
      return "No";
    }
  }

  return "Yes";
}
