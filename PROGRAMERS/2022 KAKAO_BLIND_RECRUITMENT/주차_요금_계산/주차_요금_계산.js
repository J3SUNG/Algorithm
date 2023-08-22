function solution(fees, records) {
  let inCar = [];
  let outCar = [];
  let answer = [];
  for (let i = 0; i < records.length; ++i) {
    let arr = records[i].split(" ");
    let time = arr[0].split(":");
    let number = parseInt(arr[1]);
    let dir = arr[2];
    time = parseInt(time[0] * 60) + parseInt(time[1]);
    if (dir === "IN") {
      inCar[number] = time;
    } else if (dir === "OUT") {
      let calcTime = time - inCar[number];
      inCar[number] = -1;
      outCar[number] >= 0
        ? (outCar[number] += calcTime)
        : (outCar[number] = calcTime);
    }
  }
  for (let i = 0; i < 10000; ++i) {
    if (inCar[i] >= 0) {
      let calcTime = 1439 - inCar[i];
      outCar[i] >= 0 ? (outCar[i] += calcTime) : (outCar[i] = calcTime);
    }
    if (outCar[i] >= 0) {
      let fee = fees[1];
      if (outCar[i] - fees[0] > 0) {
        fee +=
          parseInt((outCar[i] - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
      }
      answer.push(fee);
    }
  }
  return answer;
}
