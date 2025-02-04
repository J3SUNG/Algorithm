function calc(a, b, c = 0) {
  return Math.floor((a + b) / 2) + c;
}

function getCount(sy, sx, ey, ex, arr) {
  if (sy === ey && sx === ex) {
    return arr[sy - 1][sx - 1] === 1 ? [0, 1] : [1, 0];
  }

  let midY = calc(sy, ey);
  let midX = calc(sx, ex);

  const counts = [
    getCount(sy, sx, midY, midX, arr),
    getCount(sy, midX + 1, midY, ex, arr),
    getCount(midY + 1, sx, ey, midX, arr),
    getCount(midY + 1, midX + 1, ey, ex, arr),
  ];

  let [zero, one] = counts.reduce(([z, o], [newZ, newO]) => [z + newZ, o + newO], [0, 0]);

  if (one === 4 && zero === 0) {
    return [0, 1];
  } else if (one === 0 && zero === 4) {
    return [1, 0];
  }

  return [zero, one];
}

function solution(arr) {
  return getCount(1, 1, arr.length, arr.length, arr);
}
