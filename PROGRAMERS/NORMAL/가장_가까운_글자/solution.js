function solution(s) {
  const map = new Map();
  const answer = Array.from(s).map((item, index) => {
    if (!map.has(item)) {
      map.set(item, index);
      return -1;
    } else {
      const dist = index - map.get(item);
      map.set(item, index);
      return dist;
    }
  });

  return answer;
}
