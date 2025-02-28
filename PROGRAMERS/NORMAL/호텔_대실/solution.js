function getTime(time) {
  return parseInt(time.slice(0, 2)) * 60 + parseInt(time.slice(3));
}

function solution(book_time) {
  let answer = 0;
  let timeline = [];

  for (const [start, end] of book_time) {
    const startTime = getTime(start);
    const endTime = getTime(end) + 10;

    timeline.push([startTime, 1]);
    timeline.push([endTime, -1]);
  }

  timeline.sort((a, b) => a[0] - b[0] || a[1] - b[1]);

  let current = 0;
  for (const [_, delta] of timeline) {
    current += delta;
    answer = Math.max(answer, current);
  }

  return answer;
}
