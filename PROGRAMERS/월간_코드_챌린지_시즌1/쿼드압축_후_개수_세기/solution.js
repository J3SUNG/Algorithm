function midPos(a, b) {
  return (a + b) >> 1;
}

function isUniform(sy, sx, ey, ex, arr) {
  let value = arr[sy - 1][sx - 1];
  for (let i = sy - 1; i < ey; i++) {
    for (let j = sx - 1; j < ex; j++) {
      if (arr[i][j] !== value) return false;
    }
  }
  return true;
}

function getCount(sy, sx, ey, ex, arr) {
  if (isUniform(sy, sx, ey, ex, arr)) {
    return arr[sy - 1][sx - 1] === 1 ? [0, 1] : [1, 0];
  }

  let midY = midPos(sy, ey);
  let midX = midPos(sx, ex);

  let [zero, one] = [
    getCount(sy, sx, midY, midX, arr),
    getCount(sy, midX + 1, midY, ex, arr),
    getCount(midY + 1, sx, ey, midX, arr),
    getCount(midY + 1, midX + 1, ey, ex, arr),
  ].reduce(([z, o], [newZ, newO]) => [z + newZ, o + newO], [0, 0]);

  return [zero, one];
}

function solution(arr) {
  return getCount(1, 1, arr.length, arr.length, arr);
}
