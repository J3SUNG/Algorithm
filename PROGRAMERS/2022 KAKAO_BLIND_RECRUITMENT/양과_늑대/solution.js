function solution(info, edges) {
  let answer = 0;
  let visit = new Array(1 << info.length).fill(0);
  let r = new Array(info.length).fill(-1);
  let l = new Array(info.length).fill(-1);

  edges.forEach((item) => {
    const parent = item[0];
    const child = item[1];

    if (r[parent] === -1) {
      r[parent] = child;
    } else {
      l[parent] = child;
    }
  });

  answer = solve(1, visit, r, l, info);

  return answer;
}

function solve(bit, visit, r, l, info) {
  let answer = 1;
  let wolf = 0;
  let num = 0;

  if (visit[bit]) {
    return 0;
  }
  visit[bit] = 1;

  for (let i = 0; i < info.length; ++i) {
    if (bit & (1 << i)) {
      ++num;
      wolf += info[i];
    }
  }

  if (num <= wolf * 2) {
    return 0;
  }

  answer = num - wolf;

  for (let i = 0; i < info.length; ++i) {
    if (!(bit & (1 << i))) {
      continue;
    }

    if (l[i] !== -1) {
      answer = Math.max(answer, solve(bit | (1 << l[i]), visit, r, l, info));
    }
    if (r[i] !== -1) {
      answer = Math.max(answer, solve(bit | (1 << r[i]), visit, r, l, info));
    }
  }

  return answer;
}
