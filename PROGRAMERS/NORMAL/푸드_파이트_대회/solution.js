function solution(food) {
  const arr = [];

  for (let i = 1; i < food.length; ++i) {
    arr.push(String(i).repeat(Math.floor(food[i] / 2)));
  }

  return arr.join("") + "0" + arr.reverse().join("");
}
