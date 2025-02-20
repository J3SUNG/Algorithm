function solution(schedules, timelogs, startday) {
  let answer = 0;

  timelogs.forEach((logs, index) => {
    let timeLimit = schedules[index] + 10;
    let hour = Math.floor(timeLimit / 100);
    let minute = timeLimit % 100;

    if (minute >= 60) {
      hour += 1;
      minute -= 60;
    }
    timeLimit = hour * 100 + minute;

    const isValid = logs.every((time, day) => {
      const curDay = (day + startday - 1) % 7;
      return curDay === 5 || curDay === 6 || time <= timeLimit;
    });

    if (isValid) answer++;
  });

  return answer;
}
