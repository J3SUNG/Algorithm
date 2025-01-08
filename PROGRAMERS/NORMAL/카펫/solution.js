function solution(brown, yellow) {
  const outline = Math.floor(brown / 2) + 2;

  for (let height = 3; height <= outline - 3; ++height) {
    const width = outline - height;
    const center = width * height - brown;

    if (center === yellow) {
      return [width, height];
    }
  }
}
