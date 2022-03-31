function solution(fees, records) {
  let answer = [];
  let carFee = [];
  let carUseTime = [];
  let carRecordTime = [];
  let number;
  let time;

  for (let i = 0; i < records.length; ++i) {
    time = records[i][0] * 600;
    time += records[i][1] * 60;
    time += records[i][3] * 10;
    time += records[i][4] * 1;

    number = records[i][6] * 1000;
    number += records[i][7] * 100;
    number += records[i][8] * 10;
    number += records[i][9] * 1;

    if (records[i][11] == "I") {
      if (carUseTime[number] == undefined) {
        carUseTime[number] = 0;
      }
      carRecordTime[number] = time;
    } else {
      carUseTime[number] += time - carRecordTime[number];
      carRecordTime[number] = -1;
    }
  }

  for (let i = 0; i < 10000; ++i) {
    if (carRecordTime[i] == undefined) {
      continue;
    }
    if (carRecordTime[i] > -1) {
      carUseTime[i] += 1439 - carRecordTime[i];
    }
    carFee[i] = fees[1] * 1;
    carUseTime[i] -= fees[0] * 1;
    if (carUseTime[i] > 0) {
      carFee[i] += fees[3] * Math.ceil(carUseTime[i] / fees[2]);
    }
    answer.push(carFee[i]);
  }

  return answer;
}
