function solution(routes) {
  routes.sort((a, b) => a[1] - b[1]);

  let cameraPosition = -30001;
  let cameraCount = 0;

  for (const [start, end] of routes) {
    if (start > cameraPosition) {
      cameraCount++;
      cameraPosition = end;
    }
  }

  return cameraCount;
}
