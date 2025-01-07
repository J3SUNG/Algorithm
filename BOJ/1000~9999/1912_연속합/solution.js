const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

readline
  .on("line", function (line) {
    input.push(line);
  })
  .on("close", function () {
    const numArr = input[1].split(" ").map(Number);

    let maxSum = numArr[0];
    let currentMax = numArr[0];

    for (let i = 1; i < numArr.length; ++i) {
      currentMax = Math.max(currentMax + numArr[i], numArr[i]);
      maxSum = Math.max(maxSum, currentMax);
    }

    console.log(maxSum);

    process.exit();
  });
