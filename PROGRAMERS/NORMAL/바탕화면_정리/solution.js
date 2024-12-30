function solution(wallpaper) {
  let minX = Infinity;
  let minY = Infinity;
  let maxX = -Infinity;
  let maxY = -Infinity;

  const rows = wallpaper.length;
  const cols = wallpaper[0].length;

  for (let i = 0; i < rows; ++i) {
    for (let j = 0; j < cols; ++j) {
      if (wallpaper[i][j] === "#") {
        minX = Math.min(minX, i);
        minY = Math.min(minY, j);
        maxX = Math.max(maxX, i + 1);
        maxY = Math.max(maxY, j + 1);
      }
    }
  }

  return [minX, minY, maxX, maxY];
}
