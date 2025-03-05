function gcd(a, b) {
  while (b !== 0) {
    [a, b] = [b, a % b];
  }
  return a;
}

function gcdOfArray(arr) {
  return arr.reduce((acc, num) => gcd(acc, num), arr[0]);
}

function isValidDivisor(divisor, array) {
  return array.every((num) => num % divisor !== 0);
}

function solution(arrayA, arrayB) {
  const gcdA = gcdOfArray(arrayA);
  const gcdB = gcdOfArray(arrayB);

  let answer = 0;
  if (isValidDivisor(gcdA, arrayB)) {
    answer = Math.max(answer, gcdA);
  }
  if (isValidDivisor(gcdB, arrayA)) {
    answer = Math.max(answer, gcdB);
  }

  return answer;
}
