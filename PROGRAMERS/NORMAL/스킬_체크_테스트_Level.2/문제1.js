function solution(cacheSize, cities) {
  let answer = 0;
  let cache = [];

  for (let i = 0; i < cities.length; ++i) {
    cities[i] = cities[i].toLowerCase();
  }

  if (cacheSize == 0) {
    answer = cities.length * 5;
    return answer;
  }
  cache.push(cities[0]);
  for (let i = 1; i < cities.length; ++i) {
    for (let j = cache.length - 1; j >= 0; --j) {
      if (cities[i] == cache[j]) {
        ++answer;
        cache.splice(j, 1);
        cache.push(cities[i]);
        break;
      }
      if (j == 0) {
        answer += 5;
        if (cache.length < cacheSize) {
          cache.push(cities[i]);
        } else {
          cache.splice(j, 1);
          cache.push(cities[i]);
        }
      }
    }
  }
  return answer + 5;
}
