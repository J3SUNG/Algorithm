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
    const order = [2, 4, 0, 3, 1];
    const labels = ["H", "T", "C", "K", "G"];
    const list = input[0].split(" ").map((num, index) => {
      return {
        num: parseInt(num),
        index: order[index],
        text: labels[index],
      };
    });
    const eatList = input.slice(2).map((line) => line.split(" ").map(Number));

    let sum = list.reduce((a, c) => a + c.num, 0);
    let base = sum % 10 <= 1 ? 10 : sum % 10;

    for (const eat of eatList) {
      sum = list.reduce((a, c, i) => {
        c.num -= eat[i];
        return a + c.num;
      }, 0);

      const orderStr = list
        .filter((item) => item.num > 0)
        .sort((a, b) => (b.num === a.num ? a.index - b.index : b.num - a.num))
        .map((item) => item.text)
        .join("");

      console.log(`${sum.toString(base)}7H`);
      console.log(orderStr || "NULL");

      base = sum % 10 <= 1 ? 10 : sum % 10;
    }

    process.exit();
  });
