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
    const [N, K, T] = input[0].split(" ");
    const A = input[1]
      .split(" ")
      .map(Number)
      .sort((a, b) => b - a);
    const sum = A.reduce((a, c) => a + c, 0);
    let cnt = 0;

    for (let i = 0; i < Math.floor(sum / K); ++i) {
      cnt += K - A[i];
    }

    if (sum % K === 0 && cnt <= T) {
      console.log("YES");
    } else {
      console.log("NO");
    }

    process.exit();
  });
