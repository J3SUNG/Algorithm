function solution(name, yearning, photo) {
  const map = new Map(name.map((item, index) => [item, yearning[index]]));

  return photo.map((arr) => arr.reduce((sum, person) => sum + (map.get(person) || 0), 0));
}
