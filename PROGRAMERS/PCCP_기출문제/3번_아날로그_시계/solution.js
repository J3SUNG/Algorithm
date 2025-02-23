function solution(h1, m1, s1, h2, m2, s2) {
  const start = h1 * 3600 + m1 * 60 + s1;
  const end = h2 * 3600 + m2 * 60 + s2;

  const T1 = 3600 / 59;
  const T2 = 43200 / 719;
  const commonPeriod = 43200;

  const EPS = 1e-9;

  function countMultiples(T) {
    const k_min = Math.ceil(start / T - EPS);
    const k_max = Math.floor(end / T + EPS);
    return Math.max(0, k_max - k_min + 1);
  }

  const count1 = countMultiples(T1);
  const count2 = countMultiples(T2);
  const countCommon = countMultiples(commonPeriod);

  return count1 + count2 - countCommon;
}
